package org.mathsena.mailservice.core;

public interface EmailSenderUseCase {


    // Definir uma interface para enviar e-mails, com os seguintes métodos:
    // - sendEmail(String to, String subject, String body): envia um e-mail para o destinatário especificado, com o assunto e corpo especificados.
    // A ideia é que a implementação concreta dessa interface possa ser substituída por uma implementação que envie e-mails de verdade, ou por uma implementação que faça algo diferente, como salvar os e-mails em um banco de dados.
    // Esse é o core da aplicação. Ele não conhece nada sobre como os e-mails são enviados, apenas define a interface que deve ser implementada.
    void sendEmail(String to, String subject, String body);
}
