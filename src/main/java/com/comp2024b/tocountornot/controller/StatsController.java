package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.bean.Bill;
import com.comp2024b.tocountornot.bean.MonthStats;
import com.comp2024b.tocountornot.service.BillService;
import com.comp2024b.tocountornot.service.StatsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/card/income/{user_id}/{name}")
    @ResponseBody
    public String getCardIncomeByUserIdWithName(@PathVariable("user_id") Long user_id,
                                                @PathVariable("name") String name) {
        return statsService.getCardIncomeByUserIdWithName(user_id, name);
    }

    @RequestMapping("/card/expense/{user_id}/{name}")
    @ResponseBody
    public String getCardExpenseByUserIdWithName(@PathVariable("user_id") Long user_id,
                                                 @PathVariable("name") String name) {
        return statsService.getCardExpenseByUserIdWithName(user_id, name);
    }

    @RequestMapping("/flow/{user_id}/{date_year}/{date_month}")
    @ResponseBody
    public MonthStats getMonthBillMsgByUserIdWithYearMonth(@PathVariable("user_id") Long user_id,
                                                           @PathVariable("date_year") String date_year,
                                                           @PathVariable("date_month") String date_month) {
        MonthStats monthStats = new MonthStats();
        monthStats.setIncome(statsService.getMonthIncomeByUserIdWithYearMonth(user_id, date_year, date_month));
        monthStats.setExpense(statsService.getMonthExpenseByUserIdWithYearMonth(user_id, date_year, date_month));

        List<MonthStats.DayStats> day_bill_list = new ArrayList<>();
        List<String> date_list = statsService.getBillDateByUserIdWithYearMonth(user_id, date_year, date_month);

        for (String date : date_list) {
            MonthStats.DayStats dayStats = new MonthStats.DayStats();
            dayStats.setDate(date);
            dayStats.setIncome(statsService.getDayIncomeByUserIdWithDate(user_id, date));
            dayStats.setExpense(statsService.getDayExpenseByUserIdWithDate(user_id, date));
            List<Bill> bill_list = billService.getBillByUserIdWithDate(user_id, date);
            dayStats.setBillList(bill_list);
            day_bill_list.add(dayStats);
        }

        monthStats.setBillList(day_bill_list);
        return monthStats;
    }
}
