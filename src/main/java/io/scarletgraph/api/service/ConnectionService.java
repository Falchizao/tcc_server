package io.scarletgraph.api.service;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Connection;
import io.scarletgraph.api.generic.IService;
import io.scarletgraph.api.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConnectionService extends IService<Connection> {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public ConnectionService (UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<Connection> getAll(String username) {
        return null;
    }

    @Override
    public Optional<Connection> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Connection add(Connection model) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Connection update(Connection model, Long id) {
        return null;
    }
}
