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

    @Value("${bremerbuckner.mail.subject}")
    private String subject;

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
            mimeMessageHelper.setSubject(String.format("%s: %s", subject, message.getSubject()));
            mimeMessageHelper.setText(setBody(message), true);
            javaMailSender.send(mimeMessage);

        } catch (Exception e) {
            response = false;
            LOG.error(String.format("Exception sending mail for message: %s to: %s", message.toString(), to), e);
        }

        return response;

    }

    private String setBody(Message message) {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();

        stringBuilder.append("<table>");
        stringBuilder.append("<tr>")
                .append("<td>").append("Name:").append("</td>")
                .append("<td>").append(String.format("%s %s", message.getFirstName(), message.getLastName())).append("</td>");
        stringBuilder.append("<tr>")
                .append("<td>").append("Email:").append("</td>")
                .append("<td>").append(message.getEmail()).append("</td>");
        stringBuilder.append("<tr>")
                .append("<td>").append("Phone:").append("</td>")
                .append("<td>").append(message.getPhone()).append("</td>");
        stringBuilder.append("<tr>")
                .append("<td>").append("Practice:").append("</td>")
                .append("<td>").append(message.getPractice()).append("</td>");
        stringBuilder.append("<tr>")
                .append("<td>").append("Note:").append("</td>")
                .append("<td>").append(message.getNote()).append("</td>");
        stringBuilder.append("</tr>");
        stringBuilder.append("</table>");

        return stringBuilder.toString();
    }

}
