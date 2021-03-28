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

    public String getMonthOutcomeByUserIdWithYearMonth(Long user_id, String date_year, String date_month) {
        return billMapper.getMonthOutcomeByUserIdWithYearMonth(user_id, date_year, date_month);
    }

    public List<String> selectAccountsDateByUserIdWithYearMonth(Long user_id, String date_year, String date_month) {
        return billMapper.selectAccountsDateByUserIdWithYearMonth(user_id, date_year, date_month);
    }

    public List<Bill> selectAccountsByUserIdWithDate(Long user_id, String date) {
        return billMapper.selectAccountsByUserIdWithDate(user_id, date);
    }

    public String getDayIncomeByUserIdWithDate(Long user_id, String date) {
        return billMapper.getDayIncomeByUserIdWithDate(user_id, date);
    }

    public String getDayOutcomeByUserIdWithDate(Long user_id, String date) {
        return billMapper.getDayOutcomeByUserIdWithDate(user_id, date);
    }
}