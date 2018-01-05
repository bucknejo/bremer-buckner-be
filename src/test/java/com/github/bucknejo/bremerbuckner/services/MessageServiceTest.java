package com.github.bucknejo.bremerbuckner.services;

import com.github.bucknejo.bremerbuckner.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void serviceShouldSendEmail() throws Exception {

        Message message = new Message();
        message.setFrom("test from");
        message.setBody("test body");
        message.setPhone("test phone");
        message.setPractice("test practice");
        message.setSubject("test subject");

        boolean actual = messageService.sendMessage(message);

        assert (actual);

    }

}