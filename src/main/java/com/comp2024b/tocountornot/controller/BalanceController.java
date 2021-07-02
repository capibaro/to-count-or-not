package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.bean.Balance;
import com.comp2024b.tocountornot.service.BalanceService;
import com.comp2024b.tocountornot.service.DivisionService;
import com.comp2024b.tocountornot.util.Period;
import com.comp2024b.tocountornot.util.PeriodFactory;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.ResultFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
public class BalanceController {
    private final BalanceService balanceService;
    private final DivisionService divisionService;

    public BalanceController(BalanceService balanceService, DivisionService divisionService) {
        this.balanceService = balanceService;
        this.divisionService = divisionService;
    }

    @TokenRequired
    @GetMapping("income/cards/{year}/{month}")
    public Result getCardIncome(@RequestAttribute("uid") int uid, @PathVariable("year") int year, @PathVariable("month") int month) {
        Period period = PeriodFactory.getPeriod(year, month);
        List<Balance> balances = balanceService.getCardBalance(uid,0, period);
        return ResultFactory.getSuccessResult(balances);
    }

    @TokenRequired
    @GetMapping("income/members/{year}/{month}")
    public Result getMemberIncome(@RequestAttribute("uid") int uid, @PathVariable("year") int year, @PathVariable("month") int month) {
        Period period = PeriodFactory.getPeriod(year, month);
        List<Balance> balances = balanceService.getMemberBalance(uid,0, period);
        return ResultFactory.getSuccessResult(balances);
    }

    @TokenRequired
    @GetMapping("income/divisions/{year}/{month}")
    public Result getDivisionIncome(@RequestAttribute("uid") int uid, @PathVariable("year") int year, @PathVariable("month") int month) {
        Period period = PeriodFactory.getPeriod(year, month);
        List<Balance> balances = balanceService.getDivisionBalance(uid,0, period);
        return ResultFactory.getSuccessResult(balances);
    }

    @TokenRequired
    @GetMapping("income/categories/{division}/{year}/{month}")
    public Result getCategoryIncome(@RequestAttribute("uid") int uid,
                                     @Valid @PathVariable("division") @NotNull(message = "division cannot be null") int division,
                                     @PathVariable("year") int year, @PathVariable("month") int month) {
        List<Balance> balances = null;
        if (divisionService.ExistDivision(division, uid)) {
            Period period = PeriodFactory.getPeriod(year, month);
            balances = balanceService.getCategoryBalance(division,0, period);
        }
        return ResultFactory.getSuccessResult(balances);
    }

    @TokenRequired
    @GetMapping("expense/cards/{year}/{month}")
    public Result getCardExpense(@RequestAttribute("uid") int uid, @PathVariable("year") int year, @PathVariable("month") int month) {
        Period period = PeriodFactory.getPeriod(year, month);
        List<Balance> balances = balanceService.getCardBalance(uid,1, period);
        return ResultFactory.getSuccessResult(balances);
    }

    @TokenRequired
    @GetMapping("expense/members/{year}/{month}")
    public Result getMemberExpense(@RequestAttribute("uid") int uid, @PathVariable("year") int year, @PathVariable("month") int month) {
        Period period = PeriodFactory.getPeriod(year, month);
        List<Balance> balances = balanceService.getMemberBalance(uid,1, period);
        return ResultFactory.getSuccessResult(balances);
    }

    @TokenRequired
    @GetMapping("expense/divisions/{year}/{month}")
    public Result getDivisionExpense(@RequestAttribute("uid") int uid, @PathVariable("year") int year, @PathVariable("month") int month) {
        Period period = PeriodFactory.getPeriod(year, month);
        List<Balance> balances = balanceService.getDivisionBalance(uid,1, period);
        return ResultFactory.getSuccessResult(balances);
    }

    @TokenRequired
    @GetMapping("expense/categories/{division}/{year}/{month}")
    public Result getCategoryExpense(@RequestAttribute("uid") int uid,
                                     @Valid @PathVariable("division") @NotNull(message = "division cannot be null") int division,
                                     @PathVariable("year") int year, @PathVariable("month") int month) {
        List<Balance> balances = null;
        if (divisionService.ExistDivision(division, uid)) {
            Period period = PeriodFactory.getPeriod(year, month);
            balances = balanceService.getCategoryBalance(division,1, period);
        }
        return ResultFactory.getSuccessResult(balances);
    }
}
