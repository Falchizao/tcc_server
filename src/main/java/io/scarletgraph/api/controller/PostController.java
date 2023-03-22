package io.scarletgraph.api.controller;

import io.scarletgraph.api.domain.social.Post;
import io.scarletgraph.api.dto.postDTO.PostRequest;
import io.scarletgraph.api.dto.postDTO.PostResponse;
import io.scarletgraph.api.generic.IController;
import io.scarletgraph.api.service.CRUD.PostCRUDService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
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
        List<Post> posts = postCRUDService.getAll();

        List<PostResponse> response = posts.stream().map(postDTO -> PostResponse.builder()
                .createdDate(postDTO.getCreatedDate())
                .username(postDTO.getUser().getUsername())
                .content(postDTO.getContent())
                .build()).collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<PostResponse>> getById(Long id) {
        Optional<Post> post = postCRUDService.getById(id);
        return new ResponseEntity<>(Optional.of(modelMapper.map(post, PostResponse.class)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PostResponse> add(PostRequest model) {
        return null;
    }

    @PostMapping("/submit")
    public ResponseEntity<PostResponse> addPost(@RequestBody PostRequest content, Authentication authentication){
        postCRUDService.add(content, authentication.getName());

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

    @PostMapping("/search")
    public ResponseEntity<List<PostResponse>> getByLabel(@RequestBody String label) {
        List<Post> list = postCRUDService.getByLabel(label);

        List<PostResponse> response = list.stream().map(postDTO -> PostResponse.builder()
                .createdDate(postDTO.getCreatedDate())
                .username(postDTO.getUser().getUsername())
                .content(postDTO.getContent())
                .build()).collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

