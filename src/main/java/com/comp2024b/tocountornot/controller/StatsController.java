package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.bean.*;
import com.comp2024b.tocountornot.service.BillService;
import com.comp2024b.tocountornot.service.StatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("stats")
public class StatsController {
    
    private final StatsService statsService;
    private final BillService billService;

    public StatsController(StatsService statsService, BillService billService) {
        this.statsService = statsService;
        this.billService = billService;
    }

    @GetMapping("user/all")
    public Result getAllUser() {
        List<User> list = statsService.getAllUser();
        return Results.getSuccessResult(list);
    }

    @GetMapping("card/{uid}")
    public Result getAllCardByUserId(@PathVariable("uid") Long uid) {
        List<Card> list = statsService.getAllCardByUserId(uid);
        return Results.getSuccessResult(list);
    }

    @GetMapping("/bill/{uid}/{date}")
    public Result getBillByUserIdWithDate(@PathVariable("uid") Long uid,
                                          @PathVariable("date") String date) {
        List<Bill> list = statsService.getBillByUserIdWithDate(uid, date);
        return Results.getSuccessResult(list);
    }

    @GetMapping("/flow/{uid}/{year}/{month}")
    public Result getMonthStatsByUserIdWithYearMonth(@PathVariable("uid") Long uid,
                                                         @PathVariable("year") String year,
                                                         @PathVariable("month") String month) {
        MonthStats monthStats = new MonthStats();
        monthStats.setIncome(statsService.getMonthIncomeByUserIdWithYearMonth(uid, year, month));
        monthStats.setExpense(statsService.getMonthExpenseByUserIdWithYearMonth(uid, year, month));

        List<DayStats> bill_list = new ArrayList<>();

        List<String> date_list = statsService.getBillDateByUserIdWithYearMonth(uid, year, month);
        for (String date : date_list) {
            DayStats dayStats = new DayStats();
            dayStats.setDate(date);
            dayStats.setIncome(statsService.getDayIncomeByUserIdWithDate(uid, date));
            dayStats.setExpense(statsService.getDayExpenseByUserIdWithDate(uid, date));
            List<Bill> list = statsService.getBillByUserIdWithDate(uid, date);
            dayStats.setList(list);
            bill_list.add(dayStats);
        }

        monthStats.setList(bill_list);
        return Results.getSuccessResult(monthStats);
    }
}
