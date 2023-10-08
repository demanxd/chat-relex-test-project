package com.meteor.chat.meteor.api.model;

import org.springframework.web.bind.annotation.RequestParam;

public class User {

    private int    id;
    private String name;
    private String lastName;
    private String nickname;
    private String password;
    private String email;

    public User(int id, String name, String lastName, String nickname, String password, String email){
        this.id       = id;
        this.name     = name;
        this.lastName = lastName;
        this.password = password;
        this.nickname = nickname;
        this.email    = email;
    }

    public User() {

    }

    public boolean isEmpty() {
        if (this.name.isEmpty())
            return true;
        else
            return false;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname;}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
