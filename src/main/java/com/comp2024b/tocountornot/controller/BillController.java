package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.service.BillService;
import com.comp2024b.tocountornot.bean.MonthBillList;
import com.comp2024b.tocountornot.bean.Bill;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.ArrayList;

@RestController
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping("user/{user_id}/{date_year}/{date_month}")
    @ResponseBody
    public MonthBillList findDetailByUserIdWithYearMonth(@PathVariable("user_id") Long user_id,
                                                         @PathVariable("date_year") String date_year,
                                                         @PathVariable("date_month") String date_month) {
        MonthBillList monthBillList = new MonthBillList();
        List<MonthBillList.DayBillList> dayList = new ArrayList<>();

        monthBillList.setMonth_income(billService.getMonthIncomeByUserIdWithYearMonth(user_id, date_year, date_month));
        monthBillList.setMonth_outcome(billService.getMonthOutcomeByUserIdWithYearMonth(user_id, date_year, date_month));
        List<String> dateList = billService.selectAccountsDateByUserIdWithYearMonth(user_id, date_year, date_month);
        for (String date : dateList) {
            MonthBillList.DayBillList dayAccountsList = new MonthBillList.DayBillList();
            dayAccountsList.setDate(date);
            dayAccountsList.setDay_income(billService.getDayIncomeByUserIdWithDate(user_id, date));
            dayAccountsList.setDay_outcome(billService.getDayOutcomeByUserIdWithDate(user_id, date));
            List<Bill> list = billService.selectAccountsByUserIdWithDate(user_id, date);
            dayAccountsList.setList(list);
            dayList.add(dayAccountsList);
        }
        monthBillList.setSuccess();
        if (dayList.size() == 0) monthBillList.setFail();
        monthBillList.setDayList(dayList);
        return monthBillList;
    }
}