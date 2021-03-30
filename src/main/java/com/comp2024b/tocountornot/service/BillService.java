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

    public List<Bill> getBillByUserIdWithDate(Long user_id, String date) {
        return billMapper.getBillByUserIdWithDate(user_id, date);
    }
}