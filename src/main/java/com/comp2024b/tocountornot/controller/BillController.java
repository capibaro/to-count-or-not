package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.service.BillService;
import com.comp2024b.tocountornot.bean.Bill;
import com.comp2024b.tocountornot.service.CardService;
import com.comp2024b.tocountornot.service.CategoryService;
import com.comp2024b.tocountornot.service.MemberService;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BillController {
    private final BillService billService;
    private final CardService cardService;
    private final MemberService memberService;
    private final CategoryService categoryService;

    public BillController(BillService billService, CardService cardService,
                          MemberService memberService, CategoryService categoryService) {
        this.billService = billService;
        this.cardService = cardService;
        this.memberService = memberService;
        this.categoryService = categoryService;
    }

    @TokenRequired
    @PostMapping("bill")
    public Result insertBill(@Valid @RequestBody Bill bill, @RequestAttribute("uid") int uid) {
        if (cardService.ExistCard(bill.getCard(), uid) && memberService.ExistMember(bill.getMember(), uid)
                && categoryService.ExistCategory(bill.getCategory(), uid)) {
            billService.insertBill(bill);
        }
        return ResultFactory.getCreatedResult(bill.getId());
    }

    @TokenRequired
    @PutMapping("bill/{id}")
    public Result updateBill(@PathVariable("id") int id, @Valid @RequestBody Bill bill, @RequestAttribute("uid") int uid) {
        bill.setId(id);
        if (cardService.ExistCard(bill.getCard(), uid) && memberService.ExistMember(bill.getMember(), uid)
                && categoryService.ExistCategory(bill.getCategory(), uid)) {
            billService.updateBill(bill, uid);
        }
        return ResultFactory.getSuccessResult(bill.getId());
    }

    @TokenRequired
    @DeleteMapping("bill/{id}")
    public Result deleteBill(@PathVariable("id") Long id, @RequestAttribute("uid") int uid) {
        billService.deleteBill(id, uid);
        return ResultFactory.getSuccessResult(id);
    }

    @TokenRequired
    @GetMapping("bill/{id}")
    public Result getBillById(@PathVariable("id") Long id, @RequestAttribute("uid") int uid) {
        Bill bill = billService.getBillById(id, uid);
        return ResultFactory.getSuccessResult(bill);
    }
}