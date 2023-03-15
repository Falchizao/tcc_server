package io.scarletgraph.api.repository;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.generic.IRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends IRepository<User>{
    User findByUsernameAndPassword(String username, String password);

    List<User> findAll();

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long Id);

    User deleteById(Long Id);

    Optional<User> findUserByEmail(String email);

    User findUserByUsername(String username);

    @Query(nativeQuery = true, value = "SELECT * FROM CONNECTION where FIRST_USER_ID =:user or SECOND_USER_ID =:user")
    List<User> findAllConnections(User user);
}
