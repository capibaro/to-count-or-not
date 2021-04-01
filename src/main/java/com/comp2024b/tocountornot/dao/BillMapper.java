package com.comp2024b.tocountornot.dao;

import org.apache.ibatis.annotations.*;
import com.comp2024b.tocountornot.bean.Bill;

@Mapper
public interface BillMapper {
    @Select("select * from bill where id = #{id}")
    Bill selectBillById(@Param("id") Long id);

    @Insert("insert into bill values(#{id},#{first},#{second},#{price},#{card},#{member}," +
            "#{date},#{year},#{month},#{week},#{type},#{uid})")
    void insertBill(@Param("id") Long id, @Param("first") String first, @Param("second") String second,
                    @Param("price") double price, @Param("card") String card, @Param("member") String member,
                    @Param("date") String date, @Param("year") String year,
                    @Param("month") String month, @Param("week") String week,
                    @Param("type") String type, @Param("uid") Long uid);

    @Update("update bill set first=#{first},second=#{second},price=#{price},card=#{card},member=#{member}," +
            "date=#{date},year=#{year},month=#{month},week=#{week}," +
            "type=#{type},uid=#{uid} where id = #{id}")
    void updateBill(@Param("first") String first, @Param("second") String second, @Param("price") double price,
                    @Param("card") String card, @Param("member") String member, @Param("date") String date,
                    @Param("year") String year, @Param("month") String month, @Param("week") String week,
                    @Param("type") String type, @Param("uid") Long uid, @Param("id") Long id);

    @Delete("delete from bill where id=#{id}")
    void deleteBill(@Param("id") Long id);
}
