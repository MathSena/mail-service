package org.mathsena.mailservice.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.mathsena.mailservice.adapters.EmailSenderGateway;
import org.mathsena.mailservice.core.exception.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailService implements EmailSenderGateway {
    // Usa o serviço de e-mail da Amazon SES para enviar e-mails.
    private final AmazonSimpleEmailService amazonSimpleEmailService;


  @Autowired
  public SesEmailService(AmazonSimpleEmailService amazonSimpleEmailService) {
    this.amazonSimpleEmailService = amazonSimpleEmailService;
  }

    @Override
    public void sendEmail(String to, String subject, String body) {
        // Implementar o envio de e-mail usando o serviço da Amazon SES
        SendEmailRequest request = new SendEmailRequest()
                .withSource("mathsenalives@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
            .withMessage(new Message().withBody(new Body().withText(new Content().withData(body)))
                .withSubject(new Content().withData(subject)));

        try{
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException e) {
            throw new EmailServiceException("Error sending email", e);
        }




    }


}

