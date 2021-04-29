package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.bean.Card;
import com.comp2024b.tocountornot.service.UserService;
import com.comp2024b.tocountornot.util.result.Result;
import com.comp2024b.tocountornot.util.result.Results;
import com.comp2024b.tocountornot.service.CardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardController {

    private final CardService cardService;
    private final UserService userService;

    public CardController(CardService cardService, UserService userService) {
        this.cardService = cardService;
        this.userService = userService;
    }

    @TokenRequired
    @PostMapping("insert")
    public Result insertCard(@RequestHeader("token") String token, @RequestBody Card card) {
        int uid = userService.getUserIdWithToken(token);
        if (cardService.checkDuplicate(uid, card.getName())) {
            return Results.getFailResult("Card name already taken");
        } else {
            card.setUid(uid);
            cardService.insertCard(card);
            return Results.getSuccessResult(card.getId());
        }
    }

    @TokenRequired
    @DeleteMapping("delete/{id}")
    public Result deleteCard(@PathVariable("id") int id) {
        Card c = cardService.selectCardById(id);
        if (c == null) {
            return Results.getNotFoundResult("Card does not exist");
        } else {
            cardService.deleteCard(id);
            return Results.getSuccessResult();
        }
    }

    @TokenRequired
    @PutMapping("update/{id}")
    public Result updateCard(@RequestHeader("token") String token, @RequestBody Card card, @PathVariable("id") int id) {
        Card c = cardService.selectCardById(id);
        if (c == null) {
            return Results.getNotFoundResult("Card does not exist");
        } else {
            card.setId(id);
            card.setUid(userService.getUserIdWithToken(token));
            cardService.updateCard(card);
            return Results.getSuccessResult();
        }
    }

    @TokenRequired
    @GetMapping("{id}")
    public Result selectCardById(@RequestHeader("token") String token, @PathVariable("id") int id) {
        Card c = cardService.selectCardById(id);
        if (c == null) {
            return Results.getNotFoundResult("Card does not exist");
        } else {
            if (c.getUid() == userService.getUserIdWithToken(token)) {
                return Results.getSuccessResult(c);
            }
            else {
                return Results.getNotFoundResult("Card does not exist");
            }
        }
    }

    @TokenRequired
    @GetMapping("all")
    public Result getAllCard(@RequestHeader("token") String token) {
        int uid = userService.getUserIdWithToken(token);
        return Results.getSuccessResult(cardService.getAllCardByUid(uid));
    }
}