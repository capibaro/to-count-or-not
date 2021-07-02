package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.bean.Detail;
import com.comp2024b.tocountornot.dao.FlowMapper;
import com.comp2024b.tocountornot.util.Period;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class FlowService {
    private final FlowMapper flowMapper;

    public FlowService(FlowMapper flowMapper) {
        this.flowMapper = flowMapper;
    }

    public List<Detail> getDetails(int uid, Period period) {
        return flowMapper.getDetails(uid, period.getStart(), period.getEnd());
    }

    public BigDecimal getIncome(int uid, Period period) {
        BigDecimal income = flowMapper.getIncome(uid, period.getStart(), period.getEnd());
        return Objects.requireNonNullElseGet(income, () -> new BigDecimal("0"));
    }

    public BigDecimal getExpense(int uid, Period period) {
        BigDecimal expense = flowMapper.getExpense(uid, period.getStart(), period.getEnd());
        return Objects.requireNonNullElseGet(expense, () -> new BigDecimal("0"));
    }
}