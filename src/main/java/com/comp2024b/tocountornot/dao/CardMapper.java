package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Card;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CardMapper {
    List<Card> getCardByUserIdWithName(Long user_id, String name);

    List<Card> getAllCardByUserId(Long user_id);

    int deleteCardByUserIdWithName(Long user_id, String name);
}
