package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.Results;
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

    @TokenRequired
    @GetMapping("{id}")
    public Result selectBillById(@PathVariable("id") Long id) {
        Bill bill = billService.selectBillById(id);
        return Results.getSuccessResult(bill);
    }

    @TokenRequired
    @DeleteMapping("delete/{id}")
    public Result deleteBill(@PathVariable("id") Long id) {
        billService.deleteBill(id);
        return Results.getSuccessResult(id);
    }

    @TokenRequired
    @PostMapping("insert")
    public Result insertBill(@RequestBody Bill bill) {
        billService.insertBill(bill);
        return Results.getSuccessResult(bill.getId());
    }

    @TokenRequired
    @PutMapping("update")
    public Result updateBill(@RequestBody Bill bill) {
        billService.updateBill(bill);
        return Results.getSuccessResult(bill.getId());
    }
}