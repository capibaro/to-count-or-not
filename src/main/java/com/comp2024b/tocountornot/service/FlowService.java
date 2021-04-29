package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.bean.Bill;
import com.comp2024b.tocountornot.dao.FlowMapper;
import com.comp2024b.tocountornot.util.flow.DateFlow;
import com.comp2024b.tocountornot.util.flow.MonthFlow;
import com.comp2024b.tocountornot.util.flow.WeekFlow;
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

    public Double getBalanceByDate(int uid, String date, String type) {
        Double balance = flowMapper.getBalanceByDate(uid, date, type);
        return (balance == null) ? 0 : balance;
    }

    public Double getBalanceByWeek(int uid, String year, String week, String type) {
        Double balance = flowMapper.getBalanceByWeek(uid, year, week, type);
        return (balance == null) ? 0 : balance;
    }

    public Double getBalanceByMonth(int uid, String year, String month, String type) {
        Double balance = flowMapper.getBalanceByMonth(uid, year, month, type);
        return (balance == null) ? 0 : balance;
    }

    public List<Bill> getBillByDateCard(int uid, String date, String card) {
        return flowMapper.getBillByDateCard(uid, date, card);
    }

    public List<String> getDateInMonthByCard(int uid, String year, String month, String card) {
        return flowMapper.getDateInMonthByCard(uid, year, month, card);
    }

    public List<String> getDateInWeekByCard(int uid, String year, String week, String card) {
        return flowMapper.getDateInWeekByCard(uid, year, week, card);
    }

    public Double getBalanceByDateCard(int uid, String date, String type, String card) {
        Double balance = flowMapper.getBalanceByDateCard(uid, date, type, card);
        return (balance == null) ? 0 : balance;
    }

    public Double getBalanceByWeekCard(int uid, String year, String week, String type, String card) {
        Double balance = flowMapper.getBalanceByWeekCard(uid, year, week, type, card);
        return (balance == null) ? 0 : balance;
    }

    public Double getBalanceByMonthCard(int uid, String year, String month, String type, String card) {
        Double balance = flowMapper.getBalanceByMonthCard(uid, year, month, type, card);
        return (balance == null) ? 0 : balance;
    }

    public DateFlow getDateFlow(int uid, String date) {
        DateFlow dateFlow = new DateFlow();
        dateFlow.setDate(date);
        dateFlow.setIncome(getBalanceByDate(uid, date, "in"));
        dateFlow.setExpense(getBalanceByDate(uid, date,"out"));
        dateFlow.setList(getBillByDate(uid, date));
        return dateFlow;
    }

    public WeekFlow getWeekFlow(int uid, String year, String week) {
        WeekFlow weekFlow = new WeekFlow();
        weekFlow.setYear(year);
        weekFlow.setWeek(week);
        weekFlow.setIncome(getBalanceByWeek(uid, year, week, "in"));
        weekFlow.setExpense(getBalanceByWeek(uid, year, week, "out"));
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
        monthFlow.setIncome(getBalanceByMonth(uid, year, month, "in"));
        monthFlow.setExpense(getBalanceByMonth(uid, year, month, "out"));
        List<DateFlow> list = new ArrayList<>();
        List<String> date_list = getDateInMonth(uid, year, month);
        for (String date : date_list) {
            DateFlow dateFlow = getDateFlow(uid, date);
            list.add(dateFlow);
        }
        monthFlow.setList(list);
        return monthFlow;
    }

    public DateFlow getDateFlowByCard(int uid, String date, String card) {
        DateFlow dateFlow = new DateFlow();
        dateFlow.setDate(date);
        dateFlow.setIncome(getBalanceByDateCard(uid, date, "in", card));
        dateFlow.setExpense(getBalanceByDateCard(uid, date,"out", card));
        dateFlow.setList(getBillByDateCard(uid, date, card));
        return dateFlow;
    }

    public WeekFlow getWeekFlowByCard(int uid, String year, String week, String card) {
        WeekFlow weekFlow = new WeekFlow();
        weekFlow.setYear(year);
        weekFlow.setWeek(week);
        weekFlow.setIncome(getBalanceByWeekCard(uid, year, week, "in", card));
        weekFlow.setExpense(getBalanceByWeekCard(uid, year, week, "out", card));
        List<DateFlow> list = new ArrayList<>();
        List<String> date_list = getDateInWeekByCard(uid, year, week, card);
        for (String date : date_list) {
            DateFlow dateFlow = getDateFlowByCard(uid, date, card);
            list.add(dateFlow);
        }
        weekFlow.setList(list);
        return weekFlow;
    }

    public MonthFlow getMonthFlowByCard(int uid, String year, String month, String card) {
        MonthFlow monthFlow = new MonthFlow();
        monthFlow.setYear(year);
        monthFlow.setMonth(month);
        monthFlow.setIncome(getBalanceByMonthCard(uid, year, month, "in", card));
        monthFlow.setExpense(getBalanceByMonthCard(uid, year, month, "out", card));
        List<DateFlow> list = new ArrayList<>();
        List<String> date_list = getDateInMonthByCard(uid, year, month, card);
        for (String date : date_list) {
            DateFlow dateFlow = getDateFlowByCard(uid, date, card);
            list.add(dateFlow);
        }
        monthFlow.setList(list);
        return monthFlow;
    }
}