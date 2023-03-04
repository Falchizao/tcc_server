package io.scarletgraph.api.repository;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Post;
import io.scarletgraph.api.generic.IRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends IRepository<Post> {

    List<Post> findPostByUserOrderById(User user);

    List<Post> findAllByOrderByIdDesc();

    Optional<Post> findById(Long id);

}
