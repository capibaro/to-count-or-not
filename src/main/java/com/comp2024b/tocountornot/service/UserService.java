package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.bean.User;
import com.comp2024b.tocountornot.dao.UserMapper;
import com.comp2024b.tocountornot.exception.ConflictException;
import com.comp2024b.tocountornot.exception.ForbiddenException;
import com.comp2024b.tocountornot.exception.NotFoundException;
import com.comp2024b.tocountornot.util.Digest;
import com.comp2024b.tocountornot.util.Salt;
import com.comp2024b.tocountornot.util.Token;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void register(User user) {
        if (!ExistUser(user.getName())) {
            String salt = Salt.getSalt();
            user.setPassword(Digest.hash(user.getPassword(),salt));
            user.setSalt(salt);
            userMapper.insertUser(user);
        } else {
            throw new ConflictException("username already taken");
        }
    }

    public String login(User user) {
        if (ExistUser(user.getName())) {
            User u = getUserByName(user.getName());
            String salt = u.getSalt();
            String hash = Digest.hash(user.getPassword(),salt);
            if (hash.equals(u.getPassword())) {
                return Token.create(String.valueOf(u.getId()));
            } else {
                throw new ForbiddenException("wrong password");
            }
        } else {
            throw new NotFoundException("user not exist");
        }
    }

    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    public void updateUser(User user) {
        User u = getUserById(user.getId());
        if (u.getName().equals(user.getName())) {
            String salt = Salt.getSalt();
            user.setPassword(Digest.hash(user.getPassword(),salt));
            user.setSalt(salt);
            userMapper.updateUser(user);
        } else {
            throw new ForbiddenException("cannot modify username");
        }
    }

    public User getUserByName(String name) {
        User user = userMapper.getUserByName(name);
        if (user != null) {
            return user;
        } else {
            throw new NotFoundException("user not exist");
        }
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public boolean ExistUser(String name) {
        User user = userMapper.getUserByName(name);
        return user != null;
    }
}