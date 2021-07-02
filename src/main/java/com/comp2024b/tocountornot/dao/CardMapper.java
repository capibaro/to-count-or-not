package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Card;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CardMapper {
    @Insert("insert into card (c_id,u_id,c_name) values (#{id},#{user},#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "c_id", keyProperty = "id")
    void insertCard(Card card);

    @Delete("delete from card where c_id=#{id}")
    void deleteCard(@Param("id") int id);

    @Update("update card set c_name=#{name} where c_id=#{id}")
    void updateCard(Card card);

    @Select("select c_id as id,c_name as name from card where u_id=#{uid}")
    List<Card> getAllCard(@Param("uid") int uid);

    @Select("select c_id as id,c_name as name from card where c_id=#{id} and u_id=#{uid}")
    Card getCardById(@Param("id") int id, @Param("uid") int uid);
}
