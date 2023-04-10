package io.scarletgraph.api.controller;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.dto.userDTO.UserFetchRequest;
import io.scarletgraph.api.dto.userDTO.UserRequest;
import io.scarletgraph.api.dto.userDTO.UserResponse;
import io.scarletgraph.api.generic.IController;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.service.CRUD.UserCRUDService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController extends IController<UserResponse, ResponseEntity<?>, UserRequest> {

    private final ModelMapper modelMapper;
    private final UserCRUDService userCRUDService;

    public UserController (UserCRUDService userCRUDService) {
        this.modelMapper = new ModelMapper();
        this.userCRUDService = userCRUDService;
    }

    @PostMapping("/type")
    public ResponseEntity<?> setUserType(@RequestBody Integer type, Authentication authentication){
        userCRUDService.setUserType(type, authentication.getName());

        log.info("Updated user type");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/page")
    public Page<User> get(Pageable pageable) {
        return userCRUDService.getByPage(pageable);
    }

    @PostMapping("/owninfo")
    public ResponseEntity<UserResponse> getINfo(HttpServletRequest httpServletRequest) {
        UserResponse user = userCRUDService.getAllUserInfo(httpServletRequest.getUserPrincipal().getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/fetchallByUsername")
    public ResponseEntity<List<User>> getByFilter(@RequestBody UserFetchRequest fetchRequest) {
        List<User> users = userCRUDService.getAllBySubStr(fetchRequest.getUserStr());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @PostMapping("/findByUsername")
    public ResponseEntity<User> getByUsername(@RequestParam(name = "name") String username) {
        User user = userCRUDService.getUserDetails(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserResponse>> getAll(HttpServletRequest httpServletRequest) {
        List<UserDTO> usersDTO = userCRUDService.getAll(null);

        return new ResponseEntity<>(usersDTO.stream()
                .map(personDTO -> modelMapper.map(personDTO, UserResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<UserResponse>> getById(Long id) {
        Optional<UserDTO> dto = userCRUDService.getById(id);

        return new ResponseEntity<>(Optional.of(modelMapper.map(dto, UserResponse.class)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> add(UserRequest model) {
        UserDTO dto = userCRUDService.add(modelMapper.map(model, UserDTO.class));

        return new ResponseEntity<>(modelMapper.map(dto, UserResponse.class), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        userCRUDService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<UserResponse> update(UserRequest model, Long id) {
        UserDTO dto = userCRUDService.update(modelMapper.map(model, UserDTO.class), id);

        return new ResponseEntity<>(modelMapper.map(dto, UserResponse.class), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<UserResponse> updateProfile(@RequestBody UserRequest model, Authentication authentication) {
        UserResponse updated_user = userCRUDService.updateProfile(model, authentication.getName());
        return new ResponseEntity<>(updated_user, HttpStatus.OK);
    }
}
