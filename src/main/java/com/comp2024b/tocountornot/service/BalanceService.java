package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.bean.Balance;
import com.comp2024b.tocountornot.dao.BalanceMapper;
import com.comp2024b.tocountornot.util.Period;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService {
    private final BalanceMapper balanceMapper;

    public BalanceService(BalanceMapper balanceMapper) { this.balanceMapper = balanceMapper; }

    public List<Balance> getCardBalance(int uid, int type, Period period) {
        return balanceMapper.getCardBalance(uid, type, period.getStart(), period.getEnd());
    }

    public List<Balance> getMemberBalance(int uid, int type, Period period) {
        return balanceMapper.getMemberBalance(uid, type, period.getStart(), period.getEnd());
    }

    public List<Balance> getDivisionBalance(int uid, int type, Period period) {
        return balanceMapper.getDivisionBalance(uid, type, period.getStart(), period.getEnd());
    }

    public List<Balance> getCategoryBalance(int division, int type, Period period) {
        return balanceMapper.getCategoryBalance(division, type, period.getStart(), period.getEnd());
    }
}
