package io.scarletgraph.api.repository;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Post;
import io.scarletgraph.api.generic.IRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends IRepository<Post> {

    List<Post> findPostByUserOrderById(User user);

    List<Post> findAllByOrderByIdDesc();

    Optional<Post> findById(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM POST WHERE CONTENT like '%:label%'")
    List<Post> getByLabel(String label);

    @Query(nativeQuery = true, value = "select post.* from post inner join connection c on c.following = post.tb_user_id where c.follower =:user")
    List<Post> fetchallByFollowing(User user);

}
