package io.scarletgraph.api.controller;

import io.scarletgraph.api.domain.User;
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
    public ResponseEntity<List<User>> getAllConnections(Authentication authentication) {
        List<User> connectionsList = userCRUDService.getAllConnections(authentication.getName());
        return new ResponseEntity<>(connectionsList, HttpStatus.OK);
    }


    @PostMapping("/follow")
    public ResponseEntity<?> addConnection(@RequestParam(name = "name") String username, Authentication authentication){
        userCRUDService.addConnection(username, authentication.getName());

        log.info("now following");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
