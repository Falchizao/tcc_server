package io.scarletgraph.api.controller;

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

    public EmailController (EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail/{candidate}")
    public ResponseEntity<?> sendEmail(@PathVariable String candidate, @RequestBody Long offerID) {

        try {
            emailService.sendEmail(candidate, offerID);
            log.info("Email sent to candidate!");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}