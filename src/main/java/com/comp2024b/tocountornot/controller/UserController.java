package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.bean.Result;
import com.comp2024b.tocountornot.bean.Results;
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

    @GetMapping("{name}")
    public Result selectUserByName(@PathVariable("name") String name) {
        User user = userService.selectUserByName(name);
        return Results.getSuccessResult(user);
    }

    @PostMapping("insert")
    public Result insertUser(@RequestBody User user) {
        try {
            userService.insertUser(user.getUid(), user.getName(), user.getPassword());
        } catch (Exception e) {
            return Results.getFailResult(e.getMessage());
        }
        return Results.getSuccessResult();
    }

    @PutMapping("update/{uid}")
    public Result updateUser(@RequestBody User user, @PathVariable Long uid) {
        try {
            userService.updateUser(user.getName(), user.getPassword(), uid);
        } catch (Exception e) {
            return Results.getFailResult(e.getMessage());
        }
        return Results.getSuccessResult();
    }

    @DeleteMapping("delete/{uid}")
    public Result deleteUser(@PathVariable("uid") Long uid) {
        try {
            userService.deleteUser(uid);
        } catch (Exception e) {
            return Results.getFailResult(e.getMessage());
        }
        return Results.getSuccessResult();
    }
}