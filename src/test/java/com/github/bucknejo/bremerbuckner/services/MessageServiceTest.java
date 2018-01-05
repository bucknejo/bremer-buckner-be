package com.github.bucknejo.bremerbuckner.services;

import com.github.bucknejo.bremerbuckner.domain.Message;
import com.github.bucknejo.bremerbuckner.domain.MessageBuilder;
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

        Message message = MessageBuilder.aMessage()
                .withFirstName("Jerry")
                .withLastName("Garcia")
                .withEmail("jerry@dead.net")
                .withSubject("Help me with royalties")
                .withNote("Can you help me organize my royalties?")
                .withPractice("Civil")
                .withPhone("2015551212")
                .build();

        boolean actual = messageService.sendMessage(message);

        assert (actual);

    }

}