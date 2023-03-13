package io.scarletgraph.api.controller;

import io.scarletgraph.api.domain.Offer;
import io.scarletgraph.api.domain.social.Post;
import io.scarletgraph.api.dto.OfferDTO.OfferResponse;
import io.scarletgraph.api.dto.OfferDTO.OfferResquest;
import io.scarletgraph.api.dto.postDTO.PostRequest;
import io.scarletgraph.api.dto.postDTO.PostResponse;
import io.scarletgraph.api.dto.userDTO.UserResponse;
import io.scarletgraph.api.service.CRUD.OfferCRUDService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/offers")
public class OfferController {

    private final ModelMapper modelMapper;
    private final OfferCRUDService offerCRUDService;

    public OfferController(OfferCRUDService offerCRUDService) {
        this.modelMapper = new ModelMapper();
        this.offerCRUDService = offerCRUDService;
    }

    @GetMapping
    public ResponseEntity<List<OfferResponse>> getAll() {
        List<Offer> offers = offerCRUDService.findAll();

        List<OfferResponse> response = offers.stream()
                .map(offer -> modelMapper.map(offers, OfferResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Optional<OfferResponse>> getById(Long id) {
        Optional<Offer> offer = offerCRUDService.findById(id);
        return new ResponseEntity<>(Optional.of(modelMapper.map(offer, OfferResponse.class)), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody OfferResquest offer, Authentication authentication) {
        offerCRUDService.add(offer, authentication.getName());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<PostResponse> addOffer(@RequestBody OfferResquest offer, Authentication authentication){
        offerCRUDService.add(offer, authentication.getName());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    public ResponseEntity<PostResponse> update(PostRequest model, Long id) {
        return null;
    }
}

