package com.github.bucknejo.bremerbuckner.domain;

public class Message {

    private String firstName;
    private String lastName;
    private String email;
    private String subject;
    private String note;
    private String practice;
    private String phone;

    public Message() {}

    public Message(String firstName, String lastName, String from, String subject, String note, String practice, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = from;
        this.subject = subject;
        this.note = note;
        this.practice = practice;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", note='" + note + '\'' +
                ", practice='" + practice + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
