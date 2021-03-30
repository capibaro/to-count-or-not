package com.comp2024b.tocountornot.service;

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

    public List<Card> getAllCardByUserId(Long user_id) {
        return cardMapper.getAllCardByUserId(user_id);
    }

    public int deleteCardByUserIdWithName(Long user_id, String name) {
        return cardMapper.deleteCardByUserIdWithName(user_id, name);
    }
}
