package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.dao.BillMapper;
import org.springframework.stereotype.Service;
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

    public void deleteBill(Long id) {
        billMapper.deleteBill(id);
    }

    public void insertBill(Bill bill) {
        billMapper.insertBill(bill);
    }

    public void updateBill(Bill bill) {
        billMapper.updateBill(bill);
    }
}