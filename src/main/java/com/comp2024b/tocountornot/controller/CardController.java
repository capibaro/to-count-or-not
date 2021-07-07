package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.bean.Card;
import com.comp2024b.tocountornot.service.CardService;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @TokenRequired
    @PostMapping("card")
    public Result insertCard(@Valid @RequestBody Card card, @RequestAttribute("uid") int uid) {
        card.setUser(uid);
        cardService.insertCard(card);
        return ResultFactory.getCreatedResult(card.getId());
    }

    @TokenRequired
    @PutMapping("card/{id}")
    public Result updateCard(@PathVariable("id") int id, @Valid @RequestBody Card card, @RequestAttribute("uid") int uid) {
        card.setId(id);
        cardService.updateCard(card, uid);
        return ResultFactory.getSuccessResult(card.getId());
    }

    @TokenRequired
    @DeleteMapping("card/{id}")
    public Result deleteCard(@PathVariable("id") int id, @RequestAttribute("uid") int uid) {
        cardService.deleteCard(id, uid);
        return ResultFactory.getSuccessResult(id);
    }

    @TokenRequired
    @GetMapping("card/{id}")
    public Result getCardById(@PathVariable("id") int id, @RequestAttribute("uid") int uid) {
        Card card = cardService.getCardById(id, uid);
        return ResultFactory.getSuccessResult(card);
    }

    @TokenRequired
    @GetMapping("cards")
    public Result getAllCard(@RequestAttribute("uid") int uid) {
        List<Card> cards = cardService.getAllCard(uid);
        return ResultFactory.getSuccessResult(cards);
    }
}