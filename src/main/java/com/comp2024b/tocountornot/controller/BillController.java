package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.bean.Result;
import com.comp2024b.tocountornot.bean.Results;
import com.comp2024b.tocountornot.service.BillService;
import com.comp2024b.tocountornot.bean.Bill;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bill")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("{id}")
    public Result selectBillById(@PathVariable("id") Long id) {
        Bill bill = billService.selectBillById(id);
        return Results.getSuccessResult(bill);
    }

    @PostMapping("insert")
    public Result insertBill(@RequestBody Bill bill) {
        try {
            billService.insertBill(bill.getId(), bill.getFirst(), bill.getSecond(), bill.getPrice(),
                    bill.getCard(), bill.getMember(), bill.getDate(), bill.getYear(),
                    bill.getMonth(), bill.getWeek(), bill.getType(), bill.getUid());
        } catch (Exception e) {
            return Results.getFailResult(e.getMessage());
        }
        return Results.getSuccessResult();
    }

    @PutMapping("update/{id}")
    public Result updateBill(@RequestBody Bill bill) {
        try {
            billService.updateBill(bill.getFirst(), bill.getSecond(), bill.getPrice(),
                    bill.getCard(), bill.getMember(), bill.getDate(), bill.getYear(),
                    bill.getMonth(), bill.getWeek(), bill.getType(), bill.getUid(), bill.getId());
        } catch (Exception e) {
            return Results.getFailResult(e.getMessage());
        }
        return Results.getSuccessResult();
    }

    @DeleteMapping("delete/{id}")
    public Result deleteBill(@PathVariable("id") Long id) {
        try {
            billService.deleteBill(id);
        } catch (Exception e) {
            return Results.getFailResult(e.getMessage());
        }
        return Results.getSuccessResult();
    }
}