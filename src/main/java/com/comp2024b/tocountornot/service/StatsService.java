package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.dao.StatsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {
    private final StatsMapper statsMapper;

    public StatsService(StatsMapper statsMapper) {
        this.statsMapper = statsMapper;
    }

    public String getMonthIncomeByUserIdWithYearMonth(Long user_id, String date_year, String date_month) {
        return statsMapper.getMonthIncomeByUserIdWithYearMonth(user_id, date_year, date_month);
    }

    public String getMonthExpenseByUserIdWithYearMonth(Long user_id, String date_year, String date_month) {
        return statsMapper.getMonthExpenseByUserIdWithYearMonth(user_id, date_year, date_month);
    }

    public List<String> getBillDateByUserIdWithYearMonth(Long user_id, String date_year, String date_month) {
        return statsMapper.getBillDateByUserIdWithYearMonth(user_id, date_year, date_month);
    }

    public String getDayIncomeByUserIdWithDate(Long user_id, String date) {
        return statsMapper.getDayIncomeByUserIdWithDate(user_id, date);
    }

    public String getDayExpenseByUserIdWithDate(Long user_id, String date) {
        return statsMapper.getDayExpenseByUserIdWithDate(user_id, date);
    }

    public String getCardIncomeByUserIdWithName(Long user_id, String name) {
        return statsMapper.getCardIncomeByUserIdWithName(user_id, name);
    }
    public String getCardExpenseByUserIdWithName(Long user_id, String name) {
        return statsMapper.getCardExpenseByUserIdWithName(user_id, name);
    }
}
