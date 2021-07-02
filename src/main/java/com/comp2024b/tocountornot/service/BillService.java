package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.dao.BillMapper;
import com.comp2024b.tocountornot.exception.NotFoundException;
import org.springframework.stereotype.Service;
import com.comp2024b.tocountornot.bean.Bill;

@Service
public class BillService {
    private final BillMapper billMapper;

    public BillService(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    public void insertBill(Bill bill) {
        billMapper.insertBill(bill);
    }

    public void deleteBill(Long id, int uid) {
        if (ExistBill(id,uid)) {
            billMapper.deleteBill(id);
        } else {
            throw new NotFoundException("bill not found");
        }
    }

    public void updateBill(Bill bill, int uid) {
        if (ExistBill(bill.getId(), uid)) {
            billMapper.updateBill(bill);
        } else {
            throw new NotFoundException("bill not found");
        }
    }

    public Bill getBillById(long id, int uid) {
        Bill bill = billMapper.getBillById(id, uid);
        if (bill != null) {
            return bill;
        } else {
            throw new NotFoundException("bill not found");
        }
    }

    public boolean ExistBill(long id, int uid) {
        Bill bill = getBillById(id, uid);
        return bill != null;
    }
}