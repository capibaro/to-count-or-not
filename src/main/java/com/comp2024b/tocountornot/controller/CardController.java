package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.bean.Card;
import com.comp2024b.tocountornot.bean.Result;
import com.comp2024b.tocountornot.bean.Results;
import com.comp2024b.tocountornot.service.CardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("{id}")
    public Result selectCardById(@PathVariable("id") int id) {
        Card card = cardService.selectCardById(id);
        return Results.getSuccessResult(card);
    }

    @PostMapping("insert")
    public Result insertCard(@RequestBody Card card) {
        try {
            cardService.insertCard(card.getId(), card.getName(), card.getNote(), card.getImage(),
                    card.getIncome(), card.getExpense(), card.getBalance(), card.getUid());
        } catch (Exception e) {
            return Results.getFailResult(e.getMessage());
        }
        return Results.getSuccessResult();
    }

    @PutMapping("update/{id}")
    public Result updateCard(@RequestBody Card card) {
        try {
            cardService.updateCard(card.getName(), card.getNote(), card.getImage(), card.getIncome(),
                    card.getExpense(), card.getBalance(), card.getUid(), card.getId());
        } catch (Exception e) {
            return Results.getFailResult(e.getMessage());
        }
        return Results.getSuccessResult();
    }

    @DeleteMapping("delete/{id}")
    public Result deleteCard(@PathVariable("id") int id) {
        try {
            cardService.deleteCard(id);
        } catch (Exception e) {
            return Results.getFailResult(e.getMessage());
        }
        return Results.getSuccessResult();
    }
}