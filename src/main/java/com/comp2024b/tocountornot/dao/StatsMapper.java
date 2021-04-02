package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Bill;
import com.comp2024b.tocountornot.bean.Card;
import com.comp2024b.tocountornot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StatsMapper {
    String getMonthIncomeByUserIdWithYearMonth(Long uid, String year, String month);

    String getMonthExpenseByUserIdWithYearMonth(Long uid, String year, String month);

    List<String> getBillDateByUserIdWithYearMonth(Long uid, String year, String month);

    String getDayIncomeByUserIdWithDate(Long uid, String date);

    String getDayExpenseByUserIdWithDate(Long uid, String date);

    String getCardIncomeByUserIdWithName(Long uid, String name);

    String getCardExpenseByUserIdWithName(Long uid, String name);

    List<Bill> getBillByUserIdWithDate(Long uid, String date);

    List<Card> getAllCardByUserId(Long uid);
}
