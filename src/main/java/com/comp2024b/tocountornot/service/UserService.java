package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.bean.User;
import com.comp2024b.tocountornot.dao.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    public void insertUser(Long uid, String name, String password) {
        userMapper.insertUser(uid, name, password);
    }

    public void updateUser(String name, String password, Long uid) {
        userMapper.updateUser(name, password, uid);
    }

    public void deleteUser(Long uid) {
        userMapper.deleteUser(uid);
    }
}
