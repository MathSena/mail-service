package org.mathsena.mailservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.mathsena.mailservice.application.EmailSenderService;
import org.mathsena.mailservice.core.EmailRequest;
import org.mathsena.mailservice.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("v1/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    // Implementar o endpoint para enviar e-mails
    // O endpoint deve aceitar um POST com um JSON no corpo da requisição
    // O JSON deve ter os campos "to", "subject" e "body"
    // O campo "to" deve ser uma string com o endereço de e-mail do destinatário
    // O campo "subject" deve ser uma string com o assunto do e-mail
    // O campo "body" deve ser uma string com o corpo do e-mail
    // O endpoint deve chamar o método sendEmail do EmailSenderService, passando os valores dos campos "to", "subject" e "body" do JSON
    // O endpoint deve retornar um status 200 OK se o e-mail foi enviado com sucesso
    // O endpoint deve retornar um status 500 Internal Server Error se houve um erro ao enviar o e-mail
    // O endpoint deve logar uma mensagem com o endereço de e-mail do destinatário, o assunto e o corpo do e-mail
    // Exemplo de JSON:
    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest email) {

        try{
            emailSenderService.sendEmail(email.to(), email.subject(), email.body());
            log.info("Sending email to " + email.to() + " with subject " + email.subject() + " and body " + email.body());
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            log.error("Error sending email", e);
            return ResponseEntity.status(500).body("Error sending email");
        }

    }
}
