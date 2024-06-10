package org.mathsena.mailservice.application;

import lombok.extern.slf4j.Slf4j;
import org.mathsena.mailservice.adapters.EmailSenderGateway;
import org.mathsena.mailservice.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    // Implementar a interface EmailSenderUseCase
    @Override
    public void sendEmail(String to, String subject, String body) {
        // Implementar o envio de e-mail
        this.emailSenderGateway.sendEmail(to, subject, body);
        log.info("Sending email to " + to + " with subject " + subject + " and body " + body);
    }
}
