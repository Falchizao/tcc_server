package io.scarletgraph.api.controller;

import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.dto.userDTO.UserRequest;
import io.scarletgraph.api.dto.userDTO.UserResponse;
import io.scarletgraph.api.generic.IController;
import io.scarletgraph.api.repository.UserRepository;
import io.scarletgraph.api.service.CRUD.UserCRUDService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<?> setUserType(@RequestBody Long type){
        log.info("error");
        //userCRUDService.setUserType(type, httpServletRequest.getUserPrincipal().getName());

        return new ResponseEntity<>(HttpStatus.OK);
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
}
