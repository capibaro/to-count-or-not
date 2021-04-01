package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Card;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CardMapper {
    @Select("select * from card where id = #{id}")
    Card selectCardById(@Param("id") int id);

    @Insert("insert into card values(#{id},#{name},#{note},#{image},#{income},#{expense},#{balance},#{uid})")
    void insertCard(@Param("id") int id, @Param("name") String name, @Param("note") String note,
                    @Param("image") int image, @Param("income") double income, @Param("expense") double expense,
                    @Param("balance") double balance, @Param("uid") Long uid);

    @Update("update card set name=#{name},note=#{note},image=#{image},income=#{income},expense=#{expense},balance=#{balance},uid=#{uid} where id=#{id}")
    void updateCard(@Param("name") String name, @Param("note") String note,
    @Param("image") int image, @Param("income") double income, @Param("expense") double expense,
    @Param("balance") double balance, @Param("uid") Long uid, @Param("id") int id);

    @Delete("DELETE from card where id=#{id}")
    void deleteCard(@Param("id") int id);
}
