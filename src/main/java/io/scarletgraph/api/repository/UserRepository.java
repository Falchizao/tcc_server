package io.scarletgraph.api.repository;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Connection;
import io.scarletgraph.api.generic.IRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    List<User> findByUsernameContaining(String username);

    @Query(nativeQuery = true, value = "select * from tb_user inner join connection c on c.following = tb_user.id where c.follower =:user")
    List<User> findAllConnections(User user);
}
