package com.github.bucknejo.bremerbuckner.controllers;

import com.github.bucknejo.bremerbuckner.domain.Message;
import com.github.bucknejo.bremerbuckner.services.MessageService;
import com.github.bucknejo.bremerbuckner.utility.TestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest
public class MessageControllerTest {

    @Autowired
    private MessageController messageController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    @Test
    public void contextLoads() {
        assertThat(messageController).isNotNull();
    }

    @Test
    public void sendAndReceiveSomething() throws Exception {
        when(messageService.getSomething()).thenReturn("something");
        this.mockMvc
                .perform(get("/service/message"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("something")));
    }

    @Test
    public void serviceShouldSendEmailMock() throws Exception {
        Message message = new Message();
        message.setFrom("test from");
        message.setBody("test body");
        message.setPhone("test phone");
        message.setPractice("test practice");
        message.setSubject("test subject");
        when(messageService.sendMessage(any())).thenReturn(true);
        this.mockMvc
                .perform(post("/service/message/send")
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(message))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }


}