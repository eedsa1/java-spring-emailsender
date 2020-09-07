# Spring boot emailsender

In this project i used de dependencies: spring-boot-starter-mail, starter-web and starter-validation. The project is also using
the mailtrap tool. You need to register and get your email configuration on "inboxes -> Demo inbox".

To test it, you need a tool like postman to send a POST HTTP request to your localhost:8080/feedback in json format.

### Json i.e. code:

```json
{
  "name": "eedsa1",
  "email": "mail@test.com",
  "feedback": "message"
}
```
