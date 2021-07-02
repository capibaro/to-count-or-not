package com.comp2024b.tocountornot.dao;

import org.apache.ibatis.annotations.*;
import com.comp2024b.tocountornot.bean.Bill;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BillMapper {
    @Insert("insert into bill (b_id,c_id,m_id,ca_id,b_price,b_type,b_time) " +
            "values(#{id},#{card},#{member},#{category},#{price},#{type},#{time})")
    @Options(useGeneratedKeys = true, keyColumn = "b_id",keyProperty = "id")
    void insertBill(Bill bill);

    @Delete("delete from bill where b_id=#{id}")
    void deleteBill(@Param("id") Long id);

    @Update("update bill set b_price=#{price},b_type=#{type},b_time=#{time} where b_id=#{id}")
    void updateBill(Bill bill);

    @Select("select b_id as id,bill.c_id as card,m_id as member,ca_id as category,b_price as price,b_type as type," +
            "b_time as time from bill,card where b_id=#{id} and bill.c_id=card.c_id and card.u_id=#{uid}")
    Bill getBillById(@Param("id") Long id, @Param("uid") int uid);
}
