package com.meteor.chat.meteor.api.controller;

import com.meteor.chat.meteor.api.model.Retcode;
import com.meteor.chat.meteor.api.model.User;
import com.meteor.chat.meteor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public User getUser(@RequestParam Integer id){
        Optional user = userService.getUser(id);
        if(user.isPresent()){
            return (User) user.get();
        }
        return null;
    }

    @PutMapping("/logup")
    public Retcode logup(@RequestParam String name, @RequestParam String lastName, @RequestParam String nickname, @RequestParam String password, @RequestParam String email){
        Optional retcode = userService.setUser(name, lastName, nickname, password, email);
        return (Retcode) retcode.get();
    }

//    @PutMapping("logupdb")
//    public String logupdb(@RequestParam int id, @RequestParam String name, @RequestParam String lastName, @RequestParam String nickname, @RequestParam String email){
//        userService.setUser(name,10,email);
//        return "main";
//    }
}
