package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.service.UserService;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.Results;
import com.comp2024b.tocountornot.service.BillService;
import com.comp2024b.tocountornot.bean.Bill;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bill")
public class BillController {
    private final BillService billService;
    private final UserService userService;

    public BillController(BillService billService, UserService userService) {
        this.billService = billService;
        this.userService = userService;
    }

    @TokenRequired
    @PostMapping("insert")
    public Result insertBill(@RequestHeader("token") String token ,@RequestBody Bill bill) {
        bill.setUid(userService.getUserIdWithToken(token));
        billService.insertBill(bill);
        return Results.getSuccessResult(bill.getId());
    }

    @TokenRequired
    @DeleteMapping("delete/{id}")
    public Result deleteBill(@PathVariable("id") Long id) {
        Bill b = billService.selectBillById(id);
        if (b == null) {
            return Results.getNotFoundResult("Bill does not exist");
        } else {
            billService.deleteBill(id);
            return Results.getSuccessResult();
        }
    }

    @TokenRequired
    @PutMapping("update/{id}")
    public Result updateBill(@RequestHeader("token") String token, @RequestBody Bill bill, @PathVariable("id") Long id) {
        Bill b = billService.selectBillById(id);
        if (b == null) {
            return Results.getNotFoundResult("Bill does not exist");
        } else {
            bill.setId(id);
            bill.setUid(userService.getUserIdWithToken(token));
            billService.updateBill(bill);
            return Results.getSuccessResult();
        }
    }

    @TokenRequired
    @GetMapping("{id}")
    public Result selectBillById(@RequestHeader("token") String token, @PathVariable("id") Long id) {
        Bill b = billService.selectBillById(id);
        if (b == null) {
            return Results.getNotFoundResult("Bill does not exist");
        } else {
            if (b.getUid() == userService.getUserIdWithToken(token)) {
                return Results.getSuccessResult(b);
            }
            else {
                return Results.getNotFoundResult("Bill does not exist");
            }
        }
    }
}