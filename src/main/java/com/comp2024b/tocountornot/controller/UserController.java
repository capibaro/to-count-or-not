package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.NoTokenRequired;
import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.bean.User;
import com.comp2024b.tocountornot.service.UserService;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @NoTokenRequired
    @PostMapping("user/register")
    public Result register(@Valid @RequestBody User user) {
        userService.register(user);
        return ResultFactory.getCreatedResult();
    }

    @NoTokenRequired
    @PostMapping("user/login")
    public Result login(@Valid @RequestBody User user, HttpServletResponse response) {
        String token = userService.login(user);
        response.addHeader("Set-Cookie", token);
        return ResultFactory.getSuccessResult();
    }

    @TokenRequired
    @PutMapping("user")
    public Result update(@Valid @RequestBody User user, @RequestAttribute("uid") int uid) {
        user.setId(uid);
        userService.updateUser(user);
        return ResultFactory.getSuccessResult();
    }

    @TokenRequired
    @DeleteMapping("user")
    public Result delete(@RequestAttribute("uid") int uid) {
        userService.deleteUser(uid);
        return ResultFactory.getSuccessResult();
    }
}