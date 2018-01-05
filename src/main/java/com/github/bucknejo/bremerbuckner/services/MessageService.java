package com.github.bucknejo.bremerbuckner.services;

import com.github.bucknejo.bremerbuckner.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MessageService {

    private final static Logger LOG = LoggerFactory.getLogger(MessageService.class);

    private JavaMailSender javaMailSender;

    @Value("${bremerbuckner.mail.to}")
    private String to;

    @Value("${bremerbuckner.mail.from}")
    private String from;

    @Autowired
    public MessageService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSomething() {
        return "something";
    }

    public boolean sendMessage(Message message) {

        boolean response = true;

        try {

            LOG.info(String.format("Message: %s", message.toString()));

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(message.getSubject());
            String text = String.format("from: %s\nbody: %s", message.getFrom(), message.getBody());
            mimeMessageHelper.setText(text, true);
            javaMailSender.send(mimeMessage);

        } catch (Exception e) {
            response = false;
            LOG.error(String.format("Exception sending mail for message: %s to: %s", message.toString(), to), e);
        }

        return response;

    }

}
