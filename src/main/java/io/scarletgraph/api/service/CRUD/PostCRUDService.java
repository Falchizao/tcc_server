package io.scarletgraph.api.service.CRUD;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Post;
import io.scarletgraph.api.dto.postDTO.PostRequest;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostCRUDService {

    private final PostRepository postRepository;
    private final UserCRUDService userCRUDService;
    private final ModelMapper mapper;


    public PostCRUDService(PostRepository postRepository, UserCRUDService userCRUDService) {
        this.postRepository = postRepository;
        this.userCRUDService = userCRUDService;
        this.mapper = new ModelMapper();
    }


    public List<Post> getPostsByUser(String username) {
        try{
            Optional<UserDTO> user = userCRUDService.getByUsername(username);

            return postRepository.findPostByUserOrderById(mapper.map(user, User.class));
        } catch (Exception e){
            throw new ResourceNotFound("Error fetching profile!");
        }
    }

    public Optional<Post> getById(Long id) {
        Optional<Post> post = postRepository.findById(id);

        if(post.isEmpty()) {
            throw new ResourceNotFound("Error fetching post!");
        }

        return post;
    }


    public void add(PostRequest dto) {
        log.info("Saving post....");
        Post post = mapper.map(dto, Post.class);
        postRepository.save(post);
    }
}
