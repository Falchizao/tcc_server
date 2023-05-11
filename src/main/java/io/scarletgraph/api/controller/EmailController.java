package io.scarletgraph.api.controller;

import io.scarletgraph.api.dto.emailDTO.EmailSenderRequest;
import io.scarletgraph.api.service.CRUD.OfferCRUDService;
import io.scarletgraph.api.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;
    private final OfferCRUDService offerCRUDService;

    public EmailController (EmailService emailService, OfferCRUDService offerCRUDService) {
        this.emailService = emailService;
        this.offerCRUDService = offerCRUDService;
    }


    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailSenderRequest emailRequest) {

        try {
            emailService.sendEmail(emailRequest.getUsername(), emailRequest.getOffer_id());
            log.info("Email sent to candidate!");

            log.info("removing the offer..");
            offerCRUDService.delete(emailRequest.getOffer_id());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}