package io.scarletgraph.api.service.CRUD;

import io.scarletgraph.api.domain.Profile;
import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Connection;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.dto.userDTO.UserRequest;
import io.scarletgraph.api.dto.userDTO.UserResponse;
import io.scarletgraph.api.enums.Role;
import io.scarletgraph.api.generic.IService;
import io.scarletgraph.api.handler.modelException.ObjectInvalidException;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.repository.ConnectionRepository;
import io.scarletgraph.api.repository.UserRepository;
import io.scarletgraph.api.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.Enumerated;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserCRUDService extends IService<UserDTO> {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ConnectionRepository connectionRepository;
    private final Utils utils;
    BCryptPasswordEncoder encoder;

    public UserCRUDService(UserRepository userRepository, Utils utils, ConnectionRepository connectionRepository) {
        this.userRepository = userRepository;
        this.connectionRepository = connectionRepository;
        this.utils = utils;
        this.modelMapper = new ModelMapper();
        encoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<UserDTO> getAll(String username) {
        log.info("Fetching users...");
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public User getUserDetails(String username) {
        return userRepository.findUserByUsername(username);
    }


    public Boolean relationExists(String follower, String followed) {
        Boolean relation = false;
        try{
            User followerUser = userRepository.findUserByUsername(follower);
            User followedUser = userRepository.findUserByUsername(followed);

            Optional<Connection> connection = connectionRepository.getConnection(followerUser.getId(), followedUser.getId());

            if(!connection.isEmpty()) relation = true;

        } catch (Exception e) {
            relation = false;
        }

        return relation;

    }

    @Override
    public Optional<UserDTO> getById(Long id) {
        log.info("Trying to find desired user...");
        Optional<User> user = userRepository.findById(id);

        return Optional.of(modelMapper.map(user.get(), UserDTO.class));
    }

    public void addConnection(String connection_name, String username) {

        try{
            Connection connection = new Connection();
            connection.setFollowing(userRepository.findUserByUsername(connection_name));
            connection.setFollower(userRepository.findUserByUsername(username));
            connection.setConnection_date(utils.getDate());

            connectionRepository.save(connection);
        } catch (Exception e) {
            throw new ResourceNotFound("Error fetching users details to make a new connection!");

        }
    }

    public void removeConnection(String connection_name, String username) {

        try{
            User following = userRepository.findUserByUsername(connection_name);
            User follower = userRepository.findUserByUsername(username);

            Optional<Connection> unfollowConnection = connectionRepository.getConnection(follower.getId(), following.getId());

            if(!unfollowConnection.isEmpty()) {
                connectionRepository.delete(unfollowConnection.get());
            }


        } catch (Exception e) {
            throw new ResourceNotFound("Error fetching users details to make a new connection!");

        }
    }


    public UserResponse updateProfile(UserRequest model, String username) {
        User user = userRepository.findUserByUsername(username);

        user.getProfile().setDescription(model.getDescription());
        user.getProfile().setPreviousXP(model.getPreviousXP());
        user.getProfile().setLocation(model.getLocation());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        User updateduser = userRepository.save(user);

        return UserResponse.builder().firstName(updateduser.getFirstName())
                .lastName(updateduser.getLastName())
                .username(updateduser.getUsername())
                .email(user.getEmail())
                .role(updateduser.getRole())
                .description(updateduser.getProfile().getDescription())
                .location(updateduser.getProfile().getLocation()).build();
    }

    @Override
    public UserDTO add(UserDTO dto) {
        log.info("Adding new user...");

        User user = userRepository.findUserByUsername(dto.getUsername());

        if(user != null){
            throw new ObjectInvalidException("Credentials already used! Please try again with another username and password!");
        }

        try{
            user = modelMapper.map(dto, User.class);
            user.setProfile(new Profile());
            user = userRepository.save(user);
        }catch (Exception e){
            throw new ObjectInvalidException("Error saving new user!");
        }

        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new ResourceNotFound("User by id not found!");
        }
        log.info("Deleting user...");

        userRepository.deleteById(id);
    }

    @Override
    public UserDTO update(UserDTO dto, Long id) {
        User user = userRepository.findUserByUsername(dto.getUsername());

        if(user != null){
            user = utils.syncUpdateUser(user, dto);
        } else {
            user = modelMapper.map(dto, User.class);
            user.setProfile(new Profile());
        }

        log.info("Updating user...");
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }

    public Optional<UserDTO> getByUsername(String username) {
        log.info("Trying to find desired user...");
        User user = userRepository.findUserByUsername(username);

        return Optional.of(UserDTO.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .username(user.getUsername())
                .role(user.getRole())
                .build());
    }

    public UserResponse getAllUserInfo(String username) {
        User user = userRepository.findUserByUsername(username);
        UserResponse response = UserResponse.builder().firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .description(user.getProfile().getDescription())
                .previousXp(user.getProfile().getPreviousXP())
                .location(user.getProfile().getLocation()).build();
        return response;
    }

    public Page<User> getByPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public List<User> getAllBySubStr(String username_substr) {
        List<User> userList = userRepository.findByUsernameContaining(username_substr);
        return userList;
    }

    public void setUserType(Integer type, String username) {
        User user = userRepository.findUserByUsername(username);
        user.setRole(Role.values()[type]);

        log.info("Updating user...");
        userRepository.save(user);
    }

    public List<User> getAllConnections(String username) {
        User user = userRepository.findUserByUsername(username);
        return userRepository.findAllConnections(user);
    }
}