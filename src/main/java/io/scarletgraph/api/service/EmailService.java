package io.scarletgraph.api.service;

import io.scarletgraph.api.domain.Offer;
import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.domain.social.Post;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.service.CRUD.OfferCRUDService;
import io.scarletgraph.api.service.CRUD.PostCRUDService;
import io.scarletgraph.api.service.CRUD.UserCRUDService;
import io.scarletgraph.api.utils.Utils;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService {
    final private JavaMailSender javaMailSender;
    final private UserCRUDService userCRUDService;
    final private OfferCRUDService offerCRUDService;
    final private Utils utilsService;

    public EmailService (JavaMailSender javaMailSender, OfferCRUDService offerCRUDService, UserCRUDService userCRUDService, Utils utils) {
        this.javaMailSender = javaMailSender;
        this.userCRUDService = userCRUDService;
        this.offerCRUDService = offerCRUDService;
        this.utilsService = utils;
    }


    public void sendEmail(String cantidateName, Long postId) throws MessagingException {
        Optional<UserDTO> canditade = userCRUDService.getByUsername(cantidateName);
        Optional<Offer> offer = offerCRUDService.getById(postId);

        if(canditade.isEmpty()){ throw new ResourceNotFound("Canditade not found in system!"); }
        if(offer.isEmpty()){ throw new ResourceNotFound("Offer not found in system!");}

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(canditade.get().getEmail());
            message.setFrom("scarletgraph@gmail.com");
            message.setText(utilsService.generateEmailMessage(offer.get().getContent() + "R$" + offer.get().getSalary()));
            message.setSubject("Congratulations " + cantidateName + "!");
            javaMailSender.send(message);
        } catch (Exception e) {
            System.out.println("Erro nessa bomba");
        }

    }
}































