package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.dao.CardMapper;
import com.comp2024b.tocountornot.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import com.comp2024b.tocountornot.bean.Card;

@Service
public class CardService {

    private final CardMapper cardMapper;

    public CardService(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    public void insertCard(Card card) {
        cardMapper.insertCard(card);
    }

    public void deleteCard(int id, int uid) {
        if (ExistCard(id, uid)) {
            cardMapper.deleteCard(id);
        } else {
            throw new NotFoundException("card not found");
        }
    }

    public void updateCard(Card card, int uid) {
        if (ExistCard(card.getId(), uid)) {
            cardMapper.updateCard(card);
        } else {
            throw new NotFoundException("card not found");
        }
    }

    public Card getCardById(int id, int uid) {
        Card card = cardMapper.getCardById(id, uid);
        if (card != null) {
            return card;
        } else {
            throw new NotFoundException("card not found");
        }
    }

    public List<Card> getAllCard(int uid) {
        return cardMapper.getAllCard(uid);
    }

    public boolean ExistCard(int id, int uid) {
        Card card = getCardById(id, uid);
        return card != null;
    }
}
