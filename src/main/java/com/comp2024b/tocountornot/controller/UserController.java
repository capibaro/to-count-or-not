package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.NoTokenRequired;
import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.Results;
import com.comp2024b.tocountornot.bean.User;
import com.comp2024b.tocountornot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @NoTokenRequired
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        User u = userService.selectUserByName(user.getName());
        if (u == null) {
            return Results.getFailResult("User does not exist");
        } else {
            if (!u.getPassword().equals(user.getPassword())) {
                return Results.getFailResult("Wrong password");
            }
            else {
                String token = userService.getToken(u);
                return Results.getSuccessResult(token);
            }
        }
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
            return Results.getSuccessResult(user.getId());
        }
    }

    @TokenRequired
    @GetMapping("all")
    public Result getAllUser() {
        List<User> list = userService.getAllUser();
        return Results.getSuccessResult(list);
    }

    @TokenRequired
    @GetMapping("{id}")
    public Result selectUserById(@PathVariable("id") int id) {
        User user = userService.selectUserById(id);
        return Results.getSuccessResult(user);
    }

    @TokenRequired
    @DeleteMapping("delete/{id}")
    public Result deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return Results.getSuccessResult(id);
    }

    @TokenRequired
    @PostMapping("insert")
    public Result insertUser(@RequestBody User user) {
        userService.insertUser(user);
        return Results.getSuccessResult(user.getId());
    }

    @TokenRequired
    @PutMapping("update")
    public Result updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return Results.getSuccessResult(user.getId());
    }
}