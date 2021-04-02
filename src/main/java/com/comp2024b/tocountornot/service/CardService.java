package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.bean.User;
import com.comp2024b.tocountornot.dao.CardMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import com.comp2024b.tocountornot.bean.Card;

@Service
public class CardService {

    private final CardMapper cardMapper;

    public CardService(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    public Card selectCardById(int id) {
        return cardMapper.selectCardById(id);
    }

    public void deleteCard(int id) {
        cardMapper.deleteCard(id);
    }

    public void insertCard(Card card) {
        cardMapper.insertCard(card);
    }

    public void updateCard(Card card) {
        cardMapper.updateCard(card);
    }
}
