package com.github.bucknejo.bremerbuckner.domain;

public class Message {

    private String from;
    private String subject;
    private String body;
    private String practice;
    private String phone;

    public Message() {}

    public Message(String from, String subject, String body, String practice, String phone) {
        this.from = from;
        this.subject = subject;
        this.body = body;
        this.practice = practice;
        this.phone = phone;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", practice='" + practice + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
