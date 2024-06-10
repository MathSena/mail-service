package org.mathsena.mailservice.adapters;


import org.springframework.stereotype.Service;

@Service
public interface EmailSenderGateway {

    // Representa um contrato que intereja com um serviço de fora que envia e-mails.
    void sendEmail(String to, String subject, String body);
}
