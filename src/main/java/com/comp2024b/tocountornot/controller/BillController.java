package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.service.BillService;
import com.comp2024b.tocountornot.bean.MonthBillMsg;
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
    public MonthBillMsg findDetailByUserIdWithYearMonth(@PathVariable("user_id") Long user_id,
                                                        @PathVariable("date_year") String date_year,
                                                        @PathVariable("date_month") String date_month) {
        MonthBillMsg monthBillMsg = new MonthBillMsg();
        monthBillMsg.setIncome(billService.getMonthIncomeByUserIdWithYearMonth(user_id, date_year, date_month));
        monthBillMsg.setExpense(billService.getMonthExpenseByUserIdWithYearMonth(user_id, date_year, date_month));

        List<MonthBillMsg.DayBillMsg> day_bill_list = new ArrayList<>();
        List<String> date_list = billService.getBillDateByUserIdWithYearMonth(user_id, date_year, date_month);

        for (String date : date_list) {
            MonthBillMsg.DayBillMsg dayBillMsg = new MonthBillMsg.DayBillMsg();
            dayBillMsg.setDate(date);
            dayBillMsg.setIncome(billService.getDayIncomeByUserIdWithDate(user_id, date));
            dayBillMsg.setExpense(billService.getDayExpenseByUserIdWithDate(user_id, date));
            List<Bill> bill_list = billService.getBillByUserIdWithDate(user_id, date);
            dayBillMsg.setBillList(bill_list);
            day_bill_list.add(dayBillMsg);
        }

        monthBillMsg.setSuccess();
        if (day_bill_list.size() == 0) monthBillMsg.setFail();
        monthBillMsg.setBillList(day_bill_list);
        return monthBillMsg;
    }
}