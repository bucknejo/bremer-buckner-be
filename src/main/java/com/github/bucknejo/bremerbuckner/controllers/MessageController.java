package com.github.bucknejo.bremerbuckner.controllers;

import com.github.bucknejo.bremerbuckner.domain.Message;
import com.github.bucknejo.bremerbuckner.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getSomething() {
        return messageService.getSomething();
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public boolean sendMessage(@RequestBody Message message) {

        return messageService.sendMessage(message);

    }



}
