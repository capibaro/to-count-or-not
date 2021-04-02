package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.bean.Card;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.Results;
import com.comp2024b.tocountornot.service.CardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @TokenRequired
    @GetMapping("{id}")
    public Result selectCardById(@PathVariable("id") int id) {
        Card card = cardService.selectCardById(id);
        return Results.getSuccessResult(card);
    }

    @TokenRequired
    @DeleteMapping("delete/{id}")
    public Result deleteCard(@PathVariable("id") int id) {
        cardService.deleteCard(id);
        return Results.getSuccessResult(id);
    }

    @TokenRequired
    @PostMapping("insert")
    public Result insertCard(@RequestBody Card card) {
        cardService.insertCard(card);
        return Results.getSuccessResult(card.getId());
    }

    @TokenRequired
    @PutMapping("update")
    public Result updateCard(@RequestBody Card card) {
        cardService.updateCard(card);
        return Results.getSuccessResult(card.getId());
    }
}