package br.com.mail;

import javax.validation.ValidationException;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	private EmailConfig emailConfig;
	
	public FeedbackController(EmailConfig emailConfig) {
		this.emailConfig = emailConfig;
	}
	
	@PostMapping
	public void sendFeedback(@RequestBody FormFeedback feedback, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new ValidationException("Feedback is not valid!");
		}
		
		//Sender code
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost(this.emailConfig.getHost());
		mailSenderImpl.setPort(this.emailConfig.getPort());
		mailSenderImpl.setUsername(this.emailConfig.getUsername());
		mailSenderImpl.setPassword(this.emailConfig.getPassword());
		
		//email instance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(feedback.getEmail());
		mailMessage.setTo("eric.ed123@mail.com");
		mailMessage.setSubject("New mail from "+feedback.getName());
		mailMessage.setText(feedback.getFeedback());
		
		//send
		mailSenderImpl.send(mailMessage);
	}

}
