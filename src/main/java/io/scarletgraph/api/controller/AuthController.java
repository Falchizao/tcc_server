package io.scarletgraph.api.controller;

import io.scarletgraph.api.auth.AuthResponse;
import io.scarletgraph.api.auth.AuthService;
import io.scarletgraph.api.auth.JwtTokenService;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.dto.userDTO.UserRequest;
import io.scarletgraph.api.dto.userDTO.UserResponse;
import io.scarletgraph.api.handler.modelException.UserNotFoundInSystem;
import io.scarletgraph.api.service.CRUD.UserCRUDService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/authorization")
public class AuthController {

    private final UserCRUDService userCRUDService;
    private final ModelMapper modelMapper;
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JwtTokenService jwtTokenService;

    public AuthController(JwtTokenService jwtTokenService, UserCRUDService userCRUDService, AuthService authService, AuthenticationManager authenticationManager, PasswordEncoder encoder){
        this.jwtTokenService = jwtTokenService;
        this.userCRUDService = userCRUDService;
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.modelMapper = new ModelMapper();
    }

    @PostMapping("/login")
    public ResponseEntity<?> getUser(@Valid @RequestBody UserRequest userLogin) {
        Authentication authentication;
        try{
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch(Exception e){
            throw new UserNotFoundInSystem("Crendenciais não encontradas no sistema!");
        }
        Optional<UserDTO> dto = userCRUDService.getByUsername(userLogin.getUsername());
        AuthResponse auth = new AuthResponse();
        auth.setToken(jwtTokenService.generateJwtToken(authentication));
        auth.setUser_role(dto.get().getRole());
        return ResponseEntity.ok(auth);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@Valid @RequestBody UserRequest newUser) {

        UserDTO dto = modelMapper.map(newUser, UserDTO.class);
        dto.setPassword(encoder.encode(dto.getPassword()));

        userCRUDService.add(dto);

        return ResponseEntity.ok("Registrado com sucesso, agora você pode realizar o login!");
    }
}