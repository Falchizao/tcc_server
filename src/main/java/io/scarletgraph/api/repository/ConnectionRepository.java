package io.scarletgraph.api.repository;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Connection;
import io.scarletgraph.api.generic.IRepository;
import java.util.List;

public interface ConnectionRepository extends IRepository<Connection> {

    boolean existsByFirstUserAndSecondUser (User first, User second);
    List<Connection> findByFirstUser (User user);
}
