package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.bean.Flow;
import com.comp2024b.tocountornot.service.FlowService;
import com.comp2024b.tocountornot.util.Period;
import com.comp2024b.tocountornot.util.PeriodFactory;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.ResultFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class FlowController {
    
    private final FlowService flowService;

    public FlowController(FlowService flowService) {
        this.flowService = flowService;
    }

    @TokenRequired
    @GetMapping("flow/month/{year}/{month}")
    public Result getMonthFlow(@RequestAttribute("uid") int uid, @PathVariable("year") int year, @PathVariable("month") int month) {
        Flow flow = new Flow();
        Period period = PeriodFactory.getPeriod(year, month);
        flow.setIncome(flowService.getIncome(uid, period));
        flow.setExpense(flowService.getExpense(uid, period));
        flow.setDetails(flowService.getDetails(uid, period));
        return ResultFactory.getSuccessResult(flow);
    }

    @TokenRequired
    @GetMapping("flow/day/{year}/{month}/{day}")
    public Result getDayFlow(@RequestAttribute("uid") int uid, @PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("day") int day) {
        Flow flow = new Flow();
        Period period = PeriodFactory.getPeriod(year, month, day);
        flow.setIncome(flowService.getIncome(uid, period));
        flow.setExpense(flowService.getExpense(uid, period));
        flow.setDetails(flowService.getDetails(uid, period));
        return ResultFactory.getSuccessResult(flow);
    }
}
