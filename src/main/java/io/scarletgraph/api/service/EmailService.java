package io.scarletgraph.api.service;

import io.scarletgraph.api.ConfigProvider;
import io.scarletgraph.api.domain.Offer;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.handler.modelException.ResourceNotFound;
import io.scarletgraph.api.service.CRUD.OfferCRUDService;
import io.scarletgraph.api.service.CRUD.UserCRUDService;
import io.scarletgraph.api.utils.Utils;
import lombok.Data;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Data
public class EmailService {

    @Autowired
    private ConfigProvider configProvider;

    final private UserCRUDService userCRUDService;
    final private OfferCRUDService offerCRUDService;
    final private Utils utilsService;

    public EmailService (OfferCRUDService offerCRUDService, UserCRUDService userCRUDService, Utils utils) {
        this.userCRUDService = userCRUDService;
        this.offerCRUDService = offerCRUDService;
        this.utilsService = utils;
    }

    public void sendEmail(String cantidateName, Long postId) {
        Optional<UserDTO> canditade = userCRUDService.getByUsername(cantidateName);
        Optional<Offer> offer = offerCRUDService.getById(postId);

        if(canditade.isEmpty()){ throw new ResourceNotFound("Candidate not found in system!"); }
        if(offer.isEmpty()){ throw new ResourceNotFound("Offer not found in system!");}

        try{
            HtmlEmail htmlEmail = new HtmlEmail();

            htmlEmail.setHostName(configProvider.getProtocol());
            htmlEmail.setSmtpPort(configProvider.getPort());
            htmlEmail.setSslSmtpPort(configProvider.getPort().toString());
            htmlEmail.setAuthenticator(new DefaultAuthenticator(configProvider.getAddress(), configProvider.getPassword()));
            htmlEmail.setSSLOnConnect(true);
            htmlEmail.setFrom(configProvider.getAddress());
            htmlEmail.setSubject("Congratulations, you have been selected!");
            htmlEmail.setStartTLSRequired(true);
            htmlEmail.setTo(utilsService.getEmailToSend(canditade.get().getEmail()));
            htmlEmail.setHtmlMsg(utilsService.generateEmailMessage("<br> Description: <strong>" + offer.get().getContent() + " </strong> <br> Salary: R$<strong>" + offer.get().getSalary() + "</strong>"));

            if (htmlEmail.getMimeMessage() == null) { htmlEmail.buildMimeMessage(); }

            htmlEmail.sendMimeMessage();
        } catch (Exception e) {

            throw new ResourceNotFound("Error fetching smtp config!");
        }

    }
}































