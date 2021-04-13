package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Card;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CardMapper {
    @Select("select * from card where id=#{id}")
    Card selectCardById(@Param("id") int id);

    @Delete("DELETE from card where id=#{id}")
    void deleteCard(@Param("id") int id);

    @Insert("insert into card values(#{id},#{name},#{note},#{image},#{income},#{expense},#{balance},#{uid})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insertCard(Card card);

    @Update("update card set name=#{name},note=#{note},image=#{image},income=#{income},expense=#{expense}," +
            "balance=#{balance},uid=#{uid} where id=#{id}")
    void updateCard(Card card);
}
