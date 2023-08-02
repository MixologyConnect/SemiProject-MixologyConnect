package com.javaba.mixologyconnect.email.model.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	public static String sendEmail(String email, String serv) throws Exception{
		Properties props = new Properties();
		String vrfCode = "";

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("mixologyconnect2@gmail.com", "eulsxpujulzimlst");
			}
		});

		String subject = null;
		String content = null;

		switch (serv) {
		case "signUp":
			for (int i = 0; i < 6; i++) {
				int random = 48 + (int)Math.floor(Math.random() * 36);
				if (random > 57) random += 7;
				vrfCode += (char)random;
			}
			subject = "Mixology Connect - 회원가입 이메일 인증";
			content = "<h2 style='color:blue'>안녕하세요</h2><p>인증 코드입니다: " + vrfCode + "</p>";
			break;
		case "findPW":
			subject = "Mixology Connect - 비밀번호 찾기 이메일 인증";
			content = "<h2 style='color:blue'>안녕하세요</h2>";
		}

		Message message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress("mixologyconnect2@gmail.com", "Mixology Connect", "UTF-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(subject);
			message.setContent(content, "text/html; charset=utf-8");
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vrfCode;
	}

}
