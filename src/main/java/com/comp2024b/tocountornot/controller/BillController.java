package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.service.BillService;
import com.comp2024b.tocountornot.bean.Bill;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RestController
@RequestMapping("bill")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping("{user_id}/{date}")
    @ResponseBody
    public List<Bill> getBillByUserIdWithDate(@PathVariable("user_id") Long user_id,
                                              @PathVariable("date") String date) {
        return billService.getBillByUserIdWithDate(user_id, date);
    }
}