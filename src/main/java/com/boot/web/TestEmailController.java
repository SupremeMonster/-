package com.boot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.boot.Application;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)

public class TestEmailController {
	@Autowired
	private JavaMailSender mailSender;
	@Test
	public void sendEmail(){
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("785664852@qq.com");
		message.setReplyTo("@qq.com");
		message.setSubject("Java测试邮件接口");
		message.setText("Hi!");
		mailSender.send(message);
	}
	

}
