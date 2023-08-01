package com.javaba.mixologyconnect.member.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.javaba.mixologyconnect.cocktail.model.vo.Ingredient;
import com.javaba.mixologyconnect.cocktail.model.vo.IngredientType;

public class VerifyEmail {

	public static void sendEmail(String email) {
		Properties props = new Properties();

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

		String content = "<h2 style='color:blue'>안녕하세요</h2>";
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("mixologyconnect2@gmail.com", "관리자", "UTF-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("abs013r@gmail.com"));
			message.setSubject("Mixology Connect 이메일 인증");
			message.setContent(content, "text/html; charset=utf-8");
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
