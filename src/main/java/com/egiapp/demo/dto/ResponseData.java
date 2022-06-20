package com.egiapp.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseData<T> {
    private int status;
    private String messages;
    private T payload;

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
