package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.bean.Card;
import com.comp2024b.tocountornot.service.CardService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping("{user_id}")
    @ResponseBody
    public List<Card> getAllCardByUserId(@PathVariable("user_id") Long user_id) {
        return cardService.getAllCardByUserId(user_id);
    }
}
