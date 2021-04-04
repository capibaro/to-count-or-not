package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.bean.*;
import com.comp2024b.tocountornot.service.BillService;
import com.comp2024b.tocountornot.service.FlowService;
import com.comp2024b.tocountornot.service.UserService;
import com.comp2024b.tocountornot.util.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flow")
public class FlowController {
    
    private final FlowService flowService;
    private final BillService billService;
    private final UserService userService;

    public FlowController(FlowService flowService, BillService billService, UserService userService) {
        this.flowService = flowService;
        this.billService = billService;
        this.userService = userService;
    }

    @TokenRequired
    @GetMapping("date/{date}")
    public Result getDateFlow(@RequestHeader("token") String token, @PathVariable("date") String date) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(flowService.getDateFlow(uid, date));
    }

    @TokenRequired
    @GetMapping("week/{year}/{week}")
    public Result getWeekFlow(@RequestHeader("token") String token, @PathVariable("year") String year,
                              @PathVariable("week") String week) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(flowService.getWeekFlow(uid, year, week));
    }

    @TokenRequired
    @GetMapping("month/{year}/{month}")
    public Result getMonthFlow(@RequestHeader("token") String token, @PathVariable("year") String year,
                               @PathVariable("month") String month) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(flowService.getMonthFlow(uid, year, month));
    }
}
