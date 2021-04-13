package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.service.StatService;
import com.comp2024b.tocountornot.service.UserService;
import com.comp2024b.tocountornot.util.result.Result;
import com.comp2024b.tocountornot.util.result.Results;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stat")
public class StatController {
    private final StatService statService;
    private final UserService userService;

    public StatController(StatService statService, UserService userService) {
        this.statService = statService;
        this.userService = userService;
    }

    @TokenRequired
    @GetMapping("first/month/{year}/{month}/{type}")
    public Result getFirstStatByMonth(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("type") String type) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getFirstStatByMonth(uid, year, month, type));
    }

    @TokenRequired
    @GetMapping("first/year/{year}/{type}")
    public Result getFirstStatByYear(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("type") String type) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getFirstStatByYear(uid, year, type));
    }

    @TokenRequired
    @GetMapping("first/week/{year}/{week}/{type}")
    public Result getFirstStatByWeek(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("week") String week, @PathVariable("type") String type) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getFirstStatByWeek(uid, year, week, type));
    }

    @TokenRequired
    @GetMapping("first/date/{date}/{type}")
    public Result getFirstStatByDate(@RequestHeader("token") String token, @PathVariable("date") String date, @PathVariable("type") String type) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getFirstStatByDate(uid, date, type));
    }

    @TokenRequired
    @GetMapping("first/member/month/{year}/{month}/{type}/{member}")
    public Result getFirstStatByMonthMember(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("type") String type, @PathVariable("member") String member) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getFirstStatByMonthMember(uid, year, month, type, member));
    }

    @TokenRequired
    @GetMapping("first/member/year/{year}/{type}/{member}")
    public Result getFirstStatByYearMember(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("type") String type, @PathVariable("member") String member) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getFirstStatByYearMember(uid, year, type, member));
    }

    @TokenRequired
    @GetMapping("first/member/week/{year}/{week}/{type}/{member}")
    public Result getFirstStatByWeekMember(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("week") String week, @PathVariable("type") String type, @PathVariable("member") String member) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getFirstStatByWeekMember(uid, year, week, type, member));
    }

    @TokenRequired
    @GetMapping("first/member/date/{date}/{type}/{member}")
    public Result getFirstStatByDateMember(@RequestHeader("token") String token, @PathVariable("date") String date, @PathVariable("type") String type, @PathVariable("member") String member) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getFirstStatByDateMember(uid, date, type, member));
    }

    @TokenRequired
    @GetMapping("second/month/{year}/{month}/{type}/{first}")
    public Result getSecondStatByMonth(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("type") String type, @PathVariable("first") String first) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getSecondStatByMonth(uid, year, month, type, first));
    }

    @TokenRequired
    @GetMapping("second/year/{year}/{type}/{first}")
    public Result getSecondStatByYear(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("type") String type, @PathVariable("first") String first) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getSecondStatByYear(uid, year, type, first));
    }

    @TokenRequired
    @GetMapping("second/week/{year}/{week}/{type}/{first}")
    public Result getSecondStatByWeek(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("week") String week, @PathVariable("type") String type, @PathVariable("first") String first) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getSecondStatByWeek(uid, year, week, type, first));
    }

    @TokenRequired
    @GetMapping("second/date/{date}/{type}/{first}")
    public Result getSecondStatByDate(@RequestHeader("token") String token, @PathVariable("date") String date, @PathVariable("type") String type, @PathVariable("first") String first) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getSecondStatByDate(uid, date, type, first));
    }

    @TokenRequired
    @GetMapping("member/month/{year}/{month}/{type}")
    public Result getMemberStatByMonth(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("type") String type) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getMemberStatByMonth(uid, year, month, type));
    }

    @TokenRequired
    @GetMapping("member/year/{year}/{type}")
    public Result getMemberStatByYear(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("type") String type) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getMemberStatByYear(uid, year, type));
    }

    @TokenRequired
    @GetMapping("member/week/{year}/{week}/{type}")
    public Result getMemberStatByWeek(@RequestHeader("token") String token, @PathVariable("year") String year, @PathVariable("week") String week, @PathVariable("type") String type) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getMemberStatByWeek(uid, year, week, type));
    }

    @TokenRequired
    @GetMapping("member/date/{date}/{type}")
    public Result getMemberStatByDate(@RequestHeader("token") String token, @PathVariable("date") String date, @PathVariable("type") String type) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(statService.getMemberStatByDate(uid, date, type));
    }
}
