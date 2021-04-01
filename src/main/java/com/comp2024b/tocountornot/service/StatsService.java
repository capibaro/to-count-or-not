package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.bean.Bill;
import com.comp2024b.tocountornot.bean.Card;
import com.comp2024b.tocountornot.bean.User;
import com.comp2024b.tocountornot.dao.StatsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {
    private final StatsMapper statsMapper;

    public StatsService(StatsMapper statsMapper) {
        this.statsMapper = statsMapper;
    }

    public String getMonthIncomeByUserIdWithYearMonth(Long uid, String year, String month) {
        return statsMapper.getMonthIncomeByUserIdWithYearMonth(uid, year, month);
    }

    public List<User> getAllUser() {
        return statsMapper.getAllUser();
    }

    public String getMonthExpenseByUserIdWithYearMonth(Long uid, String year, String month) {
        return statsMapper.getMonthExpenseByUserIdWithYearMonth(uid, year, month);
    }

    public List<String> getBillDateByUserIdWithYearMonth(Long uid, String year, String month) {
        return statsMapper.getBillDateByUserIdWithYearMonth(uid, year, month);
    }

    public String getDayIncomeByUserIdWithDate(Long uid, String date) {
        return statsMapper.getDayIncomeByUserIdWithDate(uid, date);
    }

    public String getDayExpenseByUserIdWithDate(Long uid, String date) {
        return statsMapper.getDayExpenseByUserIdWithDate(uid, date);
    }

    public String getCardIncomeByUserIdWithName(Long uid, String name) {
        return statsMapper.getCardIncomeByUserIdWithName(uid, name);
    }
    public String getCardExpenseByUserIdWithName(Long uid, String name) {
        return statsMapper.getCardExpenseByUserIdWithName(uid, name);
    }

    public List<Bill> getBillByUserIdWithDate(Long uid, String date) {
        return statsMapper.getBillByUserIdWithDate(uid, date);
    }
    public List<Card> getAllCardByUserId(Long uid) {
        return statsMapper.getAllCardByUserId(uid);
    }

}
