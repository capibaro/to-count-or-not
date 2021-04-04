package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.bean.Bill;
import com.comp2024b.tocountornot.dao.FlowMapper;
import com.comp2024b.tocountornot.util.DateFlow;
import com.comp2024b.tocountornot.util.MonthFlow;
import com.comp2024b.tocountornot.util.WeekFlow;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowService {
    private final FlowMapper flowMapper;

    public FlowService(FlowMapper flowMapper) {
        this.flowMapper = flowMapper;
    }

    public List<Bill> getBillByDate(int uid, String date) {
        return flowMapper.getBillByDate(uid, date);
    }

    public List<String> getDateInMonth(int uid, String year, String month) {
        return flowMapper.getDateInMonth(uid, year, month);
    }

    public List<String> getDateInWeek(int uid, String year, String week) {
        return flowMapper.getDateInWeek(uid, year, week);
    }

    public String getIncomeByDate(int uid, String date) {
        return flowMapper.getIncomeByDate(uid, date);
    }

    public String getExpenseByDate(int uid, String date) { return flowMapper.getExpenseByDate(uid, date); }

    public String getIncomeByWeek(int uid, String year, String week) {
        return flowMapper.getIncomeByWeek(uid, year, week);
    }

    public String getExpenseByWeek(int uid, String year, String week) {
        return flowMapper.getExpenseByWeek(uid, year, week);
    }

    public String getIncomeByMonth(int uid, String year, String month) {
        return flowMapper.getIncomeByMonth(uid, year, month);
    }

    public String getExpenseByMonth(int uid, String year, String month) {
        return flowMapper.getExpenseByMonth(uid, year, month);
    }

    public DateFlow getDateFlow(int uid, String date) {
        DateFlow dateFlow = new DateFlow();
        dateFlow.setDate(date);
        dateFlow.setIncome(getIncomeByDate(uid, date));
        dateFlow.setExpense(getExpenseByDate(uid, date));
        dateFlow.setList(getBillByDate(uid, date));
        return dateFlow;
    }

    public WeekFlow getWeekFlow(int uid, String year, String week) {
        WeekFlow weekFlow = new WeekFlow();
        weekFlow.setYear(year);
        weekFlow.setWeek(week);
        weekFlow.setIncome(getIncomeByWeek(uid, year, week));
        weekFlow.setExpense(getExpenseByWeek(uid, year, week));
        List<DateFlow> list = new ArrayList<>();
        List<String> date_list = getDateInWeek(uid, year, week);
        for (String date : date_list) {
            DateFlow dateFlow = getDateFlow(uid, date);
            list.add(dateFlow);
        }
        weekFlow.setList(list);
        return weekFlow;
    }

    public MonthFlow getMonthFlow(int uid, String year, String month) {
        MonthFlow monthFlow = new MonthFlow();
        monthFlow.setYear(year);
        monthFlow.setMonth(month);
        monthFlow.setIncome(getIncomeByMonth(uid, year, month));
        monthFlow.setExpense(getExpenseByMonth(uid, year, month));
        List<DateFlow> list = new ArrayList<>();
        List<String> date_list = getDateInMonth(uid, year, month);
        for (String date : date_list) {
            DateFlow dateFlow = getDateFlow(uid, date);
            list.add(dateFlow);
        }
        monthFlow.setList(list);
        return monthFlow;
    }
}