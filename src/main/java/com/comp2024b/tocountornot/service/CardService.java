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

    public void setDefault(User user) {
        int uid = user.getId();
        cardMapper.insertCard(setCard("微信", 2131165474, uid));
        cardMapper.insertCard(setCard("支付宝", 2131165288, uid));
        cardMapper.insertCard(setCard("现金", 2131165329, uid));
    }

    public Card setCard(String name, int image, int uid) {
        Card card = new Card();
        card.setName(name);
        card.setImage(image);
        card.setUid(uid);
        return card;
    }

    public List<Card> getAllCardByUid(int uid) {
        return cardMapper.getAllCardByUid(uid);
    }

    public boolean checkDuplicate(int uid, String name) {
        List<Card> list= getAllCardByUid(uid);
        if (list == null) return false;
        for (Card c : list) {
            if(name.equals(c.getName())) {
                return true;
            }
        }
        return false;
    }
}
