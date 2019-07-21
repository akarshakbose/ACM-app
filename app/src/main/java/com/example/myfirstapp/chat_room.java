package com.example.myfirstapp;

public class chat_room {
    private String messages;

    public chat_room() {
    }

    public chat_room(String messages) {
        this.messages = messages;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
