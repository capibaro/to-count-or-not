package com.comp2024b.tocountornot.dao;

import org.apache.ibatis.annotations.Mapper;
import com.comp2024b.tocountornot.bean.Bill;
import java.util.List;

@Mapper
public interface BillMapper {
    String getMonthIncomeByUserIdWithYearMonth(Long user_id, String date_year, String date_month);

    String getMonthExpenseByUserIdWithYearMonth(Long user_id, String date_year, String date_month);

    List<String> getBillDateByUserIdWithYearMonth(Long user_id, String date_year, String date_month);

    List<Bill> getBillByUserIdWithDate(Long user_id, String date);

    String getDayIncomeByUserIdWithDate(Long user_id, String date);

    String getDayExpenseByUserIdWithDate(Long user_id, String date);
}
