package io.scarletgraph.api.service.CRUD;

import io.scarletgraph.api.domain.Profile;
import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Connection;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.dto.userDTO.UserRequest;
import io.scarletgraph.api.enums.Role;
import io.scarletgraph.api.generic.IService;
import io.scarletgraph.api.handler.modelException.ObjectInvalidException;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.repository.ConnectionRepository;
import io.scarletgraph.api.repository.UserRepository;
import io.scarletgraph.api.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
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

    @Override
    public Optional<UserDTO> getById(Long id) {
        log.info("Trying to find desired user...");
        Optional<User> user = userRepository.findById(id);

        return Optional.of(modelMapper.map(user.get(), UserDTO.class));
    }

    public void addConnection(String connection_name, String username) {

        Optional<UserDTO> connectionUser = this.getByUsername(connection_name);
        Optional<UserDTO> author = this.getByUsername(username);

        if(connectionUser.isEmpty()){ throw new ResourceNotFound("Connection user not found in system!"); }

        Connection connection = new Connection();
        connection.setFirstUser(modelMapper.map(author.get(), User.class));
        connection.setSecondUser(modelMapper.map(connectionUser.get(), User.class));
        connection.setConnection_date(utils.getDate());

        connectionRepository.save(connection);
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