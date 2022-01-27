//package com.groupe4.projet_avis.securityconfiguration;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//
//import lombok.AllArgsConstructor;
//
//@Service
//@AllArgsConstructor
//public class EmailService implements EmailSender{
//	private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
//    private final JavaMailSender mailSender;
//    
//    @Override
//    @Async
//    public void send(String to, String email) {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
//		helper.setText(email, true);
//		helper.setTo(to);
//		helper.setSubject("Confirm your email");
//		helper.setFrom("x@gmail.com");
//		mailSender.send(mimeMessage);
//    }
//
//
//}
