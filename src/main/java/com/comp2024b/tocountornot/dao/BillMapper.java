package com.comp2024b.tocountornot.dao;

import org.apache.ibatis.annotations.*;
import com.comp2024b.tocountornot.bean.Bill;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BillMapper {
    @Select("select * from bill where id = #{id}")
    Bill selectBillById(@Param("id") Long id);

    @Delete("delete from bill where id=#{id}")
    void deleteBill(@Param("id") Long id);

    @Insert("insert into bill values(#{id},#{first},#{second},#{price},#{card},#{member},#{date},#{year},#{month}," +
            "#{week},#{type},#{uid})")
    @Options(useGeneratedKeys = true, keyColumn = "id",keyProperty = "id")
    void insertBill(Bill bill);

    @Update("update bill set first=#{first},second=#{second},price=#{price},card=#{card},member=#{member}," +
            "date=#{date},year=#{year},month=#{month},week=#{week},type=#{type},uid=#{uid} where id = #{id}")
    void updateBill(Bill bill);
}
