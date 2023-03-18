package io.scarletgraph.api.service.CRUD;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Post;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.repository.PostRepository;
import io.scarletgraph.api.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostCRUDService {

    private final PostRepository postRepository;
    private final UserCRUDService userCRUDService;
    private final ModelMapper mapper;
    private final Utils utils;


    public PostCRUDService(PostRepository postRepository, UserCRUDService userCRUDService, Utils utils) {
        this.postRepository = postRepository;
        this.utils = utils;
        this.userCRUDService = userCRUDService;
        this.mapper = new ModelMapper();
    }

    public List<Post> getAll() {
        return postRepository.findAll();
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

    public List<Post> getByLabel(final String label) {
        return postRepository.getByLabel(label);
    }


    public void add(String content, String username) {
        log.info("fetching data....");
        Optional<UserDTO> userdto = userCRUDService.getByUsername(username);

        log.info("creating post....");
        Post post = new Post();
        post.setContent(content);
        User user = new User();
        BeanUtils.copyProperties(userdto.get(), user);
        post.setUser(user);
        post.setCreatedDate(utils.getDate());

        log.info("Saving post....");
        postRepository.save(post);
    }
}
