package com.meteor.chat.meteor.api.model;

public class Retcode {
    private int code;
    private String description;

    public Retcode(int code, String message)
    {
        this.code = code;
        this.description = message;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
