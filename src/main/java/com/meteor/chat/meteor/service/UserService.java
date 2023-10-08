package com.meteor.chat.meteor.service;

import com.meteor.chat.meteor.api.model.Retcode;
import com.meteor.chat.meteor.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;
    public UserService() {

         userList = new ArrayList<>();

        User user0 = new User(1, "Johan","Pittsburg","Johanio","123","Johan@shitemail.com");
        User user1 = new User(2, "Oleg","Pittsburg","Olegka","123","Oleg@shitemail.com");
        User user2 = new User(3, "Pasha","Pittsburg","Pavlik","123","Pashtet@shitemail.com");
        User user3 = new User(4, "Olga","Pittsburg","Ol0","123","Olja@shitemail.com");
        User user4 = new User(5, "Richard","Sanches","RickiTickiTavi","123","Morty@shitemail.com");

        userList.addAll(Arrays.asList(user0,user1,user2,user3,user4));
    }

    public Optional<User> getUser(Integer id) {
        for (User user: userList){
            if (id == user.getId()){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<ArrayList<User>> getAllUsers() {
        return Optional.of((ArrayList<User>) userList);
    }

    private boolean checkNickname(String nickname) {
        for (User user: userList){
            if (nickname.equals(user.getNickname())){
                return false;
            }
        }
        return true;
    }

    private boolean checkEmail(String email) {
        for (User user: userList){
            if (email.equals(user.getEmail())){
                return false;
            }
        }
        return true;
    }

    private User getUserByNickname(String nickname) {
        for (User user: userList){
            if (nickname.equals(user.getNickname())){
                return user;
            }
        }
        return new User();
    }



    public Optional<Retcode> setUser(String name, String lastName, String nickname, String password, String email) {
        if (name.isEmpty()) return Optional.of(new Retcode(401, "name is empty"));
        if (lastName.isEmpty()) return Optional.of(new Retcode(401, "lastName is empty"));
        if (nickname.isEmpty()) return Optional.of(new Retcode(401, "nickname is empty"));
        if (password.isEmpty()) return Optional.of(new Retcode(401, "password is empty"));
        if (email.isEmpty()) return Optional.of(new Retcode(401, "email is empty"));
        if (!checkNickname(nickname)) return Optional.of(new Retcode(401, "nickname is reserved"));
        if (!checkEmail(email)) return Optional.of(new Retcode(401, "email is reserved"));
        User user = new User(userList.size() + 1, name, lastName, nickname, password, email);
        userList.add(user);
        return Optional.of(new Retcode(200, "Success"));
    }

    public Optional<Retcode> loginUser(String nickname, String password) {
        if (nickname.isEmpty()) return Optional.of(new Retcode(401, "nickname is empty"));
        if (password.isEmpty()) return Optional.of(new Retcode(401, "password is empty"));
        User user = getUserByNickname(nickname);
        if (user.isEmpty() || !user.getPassword().equals(password)) return Optional.of(new Retcode(401, "Wrong nickname or password"));
        return Optional.of(new Retcode(200, "Success"));
    }
}
