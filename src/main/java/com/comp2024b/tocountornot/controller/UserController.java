package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.NoTokenRequired;
import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.Results;
import com.comp2024b.tocountornot.bean.User;
import com.comp2024b.tocountornot.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @NoTokenRequired
    @PostMapping("register")
    public Result register(@RequestBody User user) {
        User u = userService.selectUserByName(user.getName());
        if (u != null) {
            return Results.getFailResult("User name already taken");
        }
        else {
            userService.insertUser(user);
            return Results.getSuccessResult();
        }
    }

    @NoTokenRequired
    @PostMapping("login")
    public Result login(@RequestBody User user) {
        User u = userService.selectUserByName(user.getName());
        if (u == null) {
            return Results.getFailResult("User does not exist");
        } else {
            if (!u.getPassword().equals(user.getPassword())) {
                return Results.getFailResult("Wrong password, login failed");
            }
            else {
                String token = userService.getUserToken(u);
                return Results.getSuccessResult(token);
            }
        }
    }

    @TokenRequired
    @DeleteMapping("delete")
    public Result deleteUser(@RequestBody User user) {
        User u = userService.selectUserByName(user.getName());
        if (u == null) {
            return Results.getNotFoundResult("User does not exist");
        } else {
            if (!u.getPassword().equals(user.getPassword())) {
                return Results.getFailResult("Wrong password, delete failed");
            }
            else {
                userService.deleteUser(u.getId());
                return Results.getSuccessResult();
            }
        }
    }

    @TokenRequired
    @PutMapping("update")
    public Result updateUser(@RequestBody User user) {
        User u = userService.selectUserByName(user.getName());
        if (u == null) {
            return Results.getNotFoundResult("User does not exist");
        } else {
            if (!u.getPassword().equals(user.getPassword())) {
                return Results.getFailResult("Wrong password, update failed");
            }
            else {
                userService.updateUser(user);
                return Results.getSuccessResult();
            }
        }
    }
}