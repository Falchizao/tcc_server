package io.scarletgraph.api.service;

import io.scarletgraph.api.domain.Offer;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.service.CRUD.OfferCRUDService;
import io.scarletgraph.api.service.CRUD.UserCRUDService;
import io.scarletgraph.api.utils.Utils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import java.util.Collection;
import java.util.Iterator;
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
            HtmlEmail htmlEmail = new HtmlEmail();

            htmlEmail.setHostName("smtp.gmail.com");
            htmlEmail.setSmtpPort(465);
            htmlEmail.setSslSmtpPort("465");

            htmlEmail.setAuthenticator(new DefaultAuthenticator("scarletgraph@gmail.com", "udlewdqpovumtdqf"));
            htmlEmail.setSSLOnConnect(true);
            htmlEmail.setFrom("scarletgraph@gmail.com");
            htmlEmail.setSubject("Congratulations, you have been selected!");
            htmlEmail.setStartTLSRequired(true);
            htmlEmail.setTo(utilsService.getEmailToSend(canditade.get().getEmail()));

            htmlEmail.setHtmlMsg(utilsService.generateEmailMessage("<br> Description: <strong>" + offer.get().getContent() + " </strong> <br> Salary: R$<strong>" + offer.get().getSalary() + "</strong>"));

            if (htmlEmail.getMimeMessage() == null) {
                htmlEmail.buildMimeMessage();
            }
            htmlEmail.sendMimeMessage();

        } catch (Exception e) {
            throw new ResourceNotFound("Error fetching smtp config!");
        }

    }
}































