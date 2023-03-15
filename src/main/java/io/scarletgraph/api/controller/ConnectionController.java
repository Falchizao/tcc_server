package io.scarletgraph.api.controller;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.dto.connectionDTO.ConnectionRequest;
import io.scarletgraph.api.dto.userDTO.UserResponse;
import io.scarletgraph.api.service.CRUD.UserCRUDService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/connections")
public class ConnectionController {
    private final UserCRUDService userCRUDService;

    public ConnectionController (UserCRUDService userCRUDService) {
        this.userCRUDService = userCRUDService;
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllConnections(Authentication authentication) {
        List<User> connectionsList = userCRUDService.getAllConnections(authentication.getName());

        return new ResponseEntity<>(connectionsList.stream()
                .map(connection -> UserResponse.builder().username(connection.getUsername()).build())
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addConnection(@RequestBody ConnectionRequest request, Authentication authentication){
        userCRUDService.addConnection(request.getConnection_name(), authentication.getName());

        log.info("Added as connection");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
