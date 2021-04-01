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

    public void insertCard(int id, String name, String note, int image,
                           double income, double expense, double balance, Long uid) {
        cardMapper.insertCard(id, name, note, image, income, expense, balance, uid);
    }

    public void updateCard(String name, String note, int image, double income,
                           double expense, double balance, Long uid, int id) {
        cardMapper.updateCard(name, note, image, income, expense, balance, uid, id);
    }

    public void deleteCard(int id) {
        cardMapper.deleteCard(id);
    }
}
