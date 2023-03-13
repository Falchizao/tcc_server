package io.scarletgraph.api.controller;

import io.scarletgraph.api.service.CRUD.ImageCRUDService;
import io.scarletgraph.api.service.CRUD.UserCRUDService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ModelMapper modelMapper;
    private final ImageCRUDService imageCRUDService;

    public ImageController (ImageCRUDService imageCRUDService, UserCRUDService userCRUDService) {
        this.modelMapper = new ModelMapper();
        this.imageCRUDService = imageCRUDService;
    }

    @PostMapping("/banner")
    public ResponseEntity<?> updateUserBanner(@RequestBody byte[] data, HttpServletRequest httpServletRequest) {

        imageCRUDService.updateBanner(data, httpServletRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/profile")
    public ResponseEntity<?> updateUserPfp(@RequestBody byte[] data, HttpServletRequest httpServletRequest) {

        imageCRUDService.updateProfilePicture(data, httpServletRequest.getUserPrincipal().getName());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
