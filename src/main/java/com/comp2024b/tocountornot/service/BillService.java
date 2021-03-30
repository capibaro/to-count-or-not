package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.dao.BillMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import com.comp2024b.tocountornot.bean.Bill;

@Service
public class BillService {
    private final BillMapper billMapper;

    public BillService(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    public String getMonthIncomeByUserIdWithYearMonth(Long user_id, String date_year, String date_month) {
        return billMapper.getMonthIncomeByUserIdWithYearMonth(user_id, date_year, date_month);
    }

    public String getMonthExpenseByUserIdWithYearMonth(Long user_id, String date_year, String date_month) {
        return billMapper.getMonthExpenseByUserIdWithYearMonth(user_id, date_year, date_month);
    }

    public List<String> getBillDateByUserIdWithYearMonth(Long user_id, String date_year, String date_month) {
        return billMapper.getBillDateByUserIdWithYearMonth(user_id, date_year, date_month);
    }

    public List<Bill> getBillByUserIdWithDate(Long user_id, String date) {
        return billMapper.getBillByUserIdWithDate(user_id, date);
    }

    public String getDayIncomeByUserIdWithDate(Long user_id, String date) {
        return billMapper.getDayIncomeByUserIdWithDate(user_id, date);
    }

    public String getDayExpenseByUserIdWithDate(Long user_id, String date) {
        return billMapper.getDayExpenseByUserIdWithDate(user_id, date);
    }
}