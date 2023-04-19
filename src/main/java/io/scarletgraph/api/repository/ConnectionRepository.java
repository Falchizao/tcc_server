package io.scarletgraph.api.repository;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Connection;
import io.scarletgraph.api.generic.IRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConnectionRepository extends IRepository<Connection> {

    @Query(nativeQuery = true, value = "select connection.* from connection  where follower=:follower and following=:followed limit 1")
    Optional<Connection> getConnection(Long follower, Long followed);

}
