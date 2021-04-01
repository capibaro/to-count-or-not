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

    public Bill selectBillById(Long id) {
        return billMapper.selectBillById(id);
    }

    public void insertBill(Long id, String first, String second, double price, String card,
                           String member, String date, String year, String month,
                           String week, String type, Long uid) {
        billMapper.insertBill(id, first, second, price, card, member, date, year, month, week, type, uid);
    }

    public void updateBill(String first, String second, double price, String card,
                           String member, String date, String year, String month,
                           String week, String type, Long uid, Long id) {
        billMapper.updateBill(first, second, price, card, member, date, year, month, week, type, uid, id);
    }

    public void deleteBill(Long id) {
        billMapper.deleteBill(id);
    }
}