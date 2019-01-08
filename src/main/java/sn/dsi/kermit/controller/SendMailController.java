package sn.dsi.kermit.controller;

import java.net.URI;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sn.dsi.kermit.model.Mail;
import sn.dsi.kermit.model.Objectif;
import sn.dsi.kermit.payload.ApiResponse;
import sn.dsi.kermit.service.EmailService;

@RestController
@RequestMapping("/mail")
public class SendMailController {
	
	    @Autowired
	    private EmailService emailService;
	  

	    @PostMapping("/send")
    public ResponseEntity<?>  sendMail( @RequestBody Mail mailRequest) {
		Mail mail = new Mail();
       
            mail.setFrom("kheuchebambiste@gmail.com");
            mail.setTo(mailRequest.getFrom());
            mail.setSubject(mailRequest.getSubject());
            mail.setContent(mailRequest.getContent());

          
      
        emailService.sendSimpleMessage(mail);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(mail.getTo()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "user alerté"));
    }

}
