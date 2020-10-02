# Spring boot emailsender

In this project i used the dependencies: spring-boot-starter-mail, starter-web and starter-validation. The project is also using
the mailtrap tool. You need to register and get your email configuration on "Inboxes -> Demo inbox". After this, you can set up
the application.properties.

To test it, you need a tool like postman to send a POST HTTP request to your localhost:8080/feedback in json format.

### Json code:

```json
{
  "name": "eedsa1",
  "email": "a.email@test.com",
  "feedback": "message"
}
```
