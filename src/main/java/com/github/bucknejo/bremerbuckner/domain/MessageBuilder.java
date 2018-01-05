package com.github.bucknejo.bremerbuckner.domain;

public final class MessageBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String subject;
    private String note;
    private String practice;
    private String phone;

    private MessageBuilder() {
    }

    public static MessageBuilder aMessage() {
        return new MessageBuilder();
    }

    public MessageBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MessageBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public MessageBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public MessageBuilder withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public MessageBuilder withNote(String note) {
        this.note = note;
        return this;
    }

    public MessageBuilder withPractice(String practice) {
        this.practice = practice;
        return this;
    }

    public MessageBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Message build() {
        Message message = new Message();
        message.setFirstName(firstName);
        message.setLastName(lastName);
        message.setEmail(email);
        message.setSubject(subject);
        message.setNote(note);
        message.setPractice(practice);
        message.setPhone(phone);
        return message;
    }
}
