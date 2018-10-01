package sn.dsi.kermit.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.dsi.kermit.model.Mail;
import sn.dsi.kermit.service.EmailService;

@RestController
public class SendMailController {
	
	    @Autowired
	    private EmailService emailService;
	  

	    @GetMapping("/sendMail")
    public String sendMail() {
		Mail mail = new Mail();
       
            mail.setFrom("kermit@gmail.com");
            mail.setTo("kheuchebambiste@gmail.com");
            mail.setSubject("kermit");
            mail.setContent("kermit app hellow");

          
      
        emailService.sendSimpleMessage(mail);
        return "Mail Sent Success!";
    }

}
