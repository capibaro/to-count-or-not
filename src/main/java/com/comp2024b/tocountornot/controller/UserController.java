package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.NoTokenRequired;
import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.service.CardService;
import com.comp2024b.tocountornot.util.result.Result;
import com.comp2024b.tocountornot.util.result.Results;
import com.comp2024b.tocountornot.bean.User;
import com.comp2024b.tocountornot.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;
    private final CardService cardService;

    public UserController(UserService userService, CardService cardService) {
        this.userService = userService;
        this.cardService = cardService;
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
            cardService.setDefault(user);
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
                return Results.getFailResult("Wrong password Login failed");
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
                return Results.getFailResult("Wrong password Delete failed");
            }
            else {
                userService.deleteUser(u.getId());
                return Results.getSuccessResult();
            }
        }
    }

    @TokenRequired
    @PutMapping("update")
    public Result updateUser(@RequestHeader("token") String token ,@RequestBody User user) {
        User u = userService.selectUserByName(user.getName());
        if (u == null) {
            return Results.getNotFoundResult("User does not exist");
        } else {
            int uid = userService.getUserIdWithToken(token);
            if (uid != u.getId()) {
                return Results.getFailResult("Invalid token Update failed");
            }
            else {
                user.setId(uid);
                userService.updateUser(user);
                return Results.getSuccessResult();
            }
        }
    }
}