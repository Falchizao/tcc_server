package io.scarletgraph.api.controller;

import io.scarletgraph.api.domain.social.Post;
import io.scarletgraph.api.dto.postDTO.PostRequest;
import io.scarletgraph.api.dto.postDTO.PostResponse;
import io.scarletgraph.api.generic.IController;
import io.scarletgraph.api.service.CRUD.PostCRUDService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/posts")
public class PostController extends IController<PostResponse, ResponseEntity<?>, PostRequest> {

    private final ModelMapper modelMapper;
    private final PostCRUDService postCRUDService;

    public PostController(PostCRUDService postCRUDService) {
        this.modelMapper = new ModelMapper();
        this.postCRUDService = postCRUDService;
    }

    @Override
    public ResponseEntity<List<PostResponse>> getAll(HttpServletRequest httpServletRequest) {
        List<Post> posts = postCRUDService.getPostsByUser(httpServletRequest.getUserPrincipal().getName());

        return new ResponseEntity<>(posts.stream()
                .map(personDTO -> modelMapper.map(posts, PostResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<PostResponse>> getById(Long id) {
        Optional<Post> post = postCRUDService.getById(id);
        return new ResponseEntity<>(Optional.of(modelMapper.map(post, PostResponse.class)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PostResponse> add(PostRequest post) {
         postCRUDService.add(post);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PostResponse> update(PostRequest model, Long id) {
        return null;
    }
}
