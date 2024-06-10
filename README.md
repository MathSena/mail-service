# Mail Service

Este é um serviço de envio de e-mails construído com Java, Spring Boot e Amazon SES.

## Requisitos

- Java 8 ou superior
- Maven
- Credenciais da AWS para o Amazon SES

## Configuração

1. Clone o repositório
2. Atualize o arquivo `src/main/java/org/mathsena/mailservice/infra/ses/AwsSesConfig.java` com suas credenciais da AWS e a região correta.
3. Compile o projeto com Maven: `mvn clean install`

## Uso

Inicie o aplicativo Spring Boot e faça uma solicitação POST para o endpoint `/v1/email` com um JSON no corpo da requisição. O JSON deve ter os campos "to", "subject" e "body".

Exemplo de JSON:

```json
{
    "to": "destinatario@example.com",
    "subject": "Assunto do e-mail",
    "body": "Corpo do e-mail"
}
```
## Sobre Clean Architecture
- infra: Este pacote contém classes que lidam com detalhes de infraestrutura, como persistência de dados, envio de e-mails, etc. No seu caso, AwsSesConfig e SesEmailService estão neste pacote, pois lidam com a configuração e uso do serviço de e-mail da Amazon SES.
- core: Este pacote contém a lógica de negócios do aplicativo, que é independente de qualquer detalhe de infraestrutura. No seu caso, EmailRequest e EmailServiceException estão neste pacote. EmailRequest é um objeto de transferência de dados (DTO) que representa um pedido de e-mail, e EmailServiceException é uma exceção personalizada que é lançada quando ocorre um erro ao enviar um e-mail.  
- adapters: Este pacote contém adaptadores que convertem dados entre a forma como são apresentados na interface do usuário ou na infraestrutura e a forma como são usados na lógica de negócios. No seu caso, EmailSenderGateway é um adaptador que define uma interface para enviar e-mails. A implementação real do envio de e-mails (usando Amazon SES) é feita em SesEmailService, que está no pacote infra.  
- controllers: Este pacote contém controladores que lidam com solicitações HTTP e retornam respostas HTTP. No seu caso, EmailSenderController está neste pacote. Este controlador aceita uma solicitação POST com um JSON no corpo da requisição, chama o método sendEmail do EmailSenderService para enviar o e-mail e retorna uma resposta HTTP.  
- application: Este pacote contém serviços que orquestram o fluxo de dados entre os controladores e a lógica de negócios. No seu caso, EmailSenderService está neste pacote. Este serviço usa EmailSenderGateway para enviar e-mails.

## Contribuição
Pull requests são bem-vindos. Para mudanças importantes, abra um problema primeiro para discutir o que você gostaria de mudar.

## Licença
[MIT](https://choosealicense.com/licenses/mit/)
```
