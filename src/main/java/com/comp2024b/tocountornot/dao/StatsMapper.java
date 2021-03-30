package com.comp2024b.tocountornot.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatsMapper {
    String getMonthIncomeByUserIdWithYearMonth(Long user_id, String date_year, String date_month);

    String getMonthExpenseByUserIdWithYearMonth(Long user_id, String date_year, String date_month);

    List<String> getBillDateByUserIdWithYearMonth(Long user_id, String date_year, String date_month);

    String getDayIncomeByUserIdWithDate(Long user_id, String date);

    String getDayExpenseByUserIdWithDate(Long user_id, String date);

    String getCardIncomeByUserIdWithName(Long user_id, String name);

    String getCardExpenseByUserIdWithName(Long user_id, String name);
}
