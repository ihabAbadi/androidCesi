package com.example.courscesiandroid.services;

import com.example.courscesiandroid.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users;

    private static UserService instance = null;

    private UserService() {
        users = new ArrayList<>();
        users.add(new User("toto", "tata"));
    }

    public static UserService getInstance() {
        if(instance == null)
            instance = new UserService();
        return instance;
    }

    public boolean login(String log, String password) {
        boolean res = false;
        for(User u: users){
            if(u.getLogin().equals(log) && u.getPassword().equals(password)){
                res = true;
                break;
            }
        }
        return res;
    }
}
