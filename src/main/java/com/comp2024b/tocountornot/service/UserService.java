package com.comp2024b.tocountornot.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.comp2024b.tocountornot.bean.User;
import com.comp2024b.tocountornot.dao.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public String getUserToken(User user) {
        String token;
        token = JWT.create().withAudience(user.getName()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public int getUserIdWithToken(String token) {
        String name;
        name = JWT.decode(token).getAudience().get(0);
        User user = selectUserByName(name);
        return user.getId();
    }
}