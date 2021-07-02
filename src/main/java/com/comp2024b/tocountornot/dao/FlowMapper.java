package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Detail;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface FlowMapper {
    @Select("select b_id as id,c_name as card,m_name as member,ca_name as category,d_name as division,b_price as price," +
            "b_type as type,b_time as time from flow where u_id=#{uid} and b_time>=#{start} and b_time<#{end} order by b_time")
    List<Detail> getDetails(@Param("uid") int uid, @Param("start") Timestamp start, @Param("end") Timestamp end);

    @Select("select sum(b_price) from flow where u_id=#{uid} and b_time>=#{start} and b_time<#{end} and b_type=0")
    BigDecimal getIncome(@Param("uid") int uid, @Param("start") Timestamp start, @Param("end") Timestamp end);

    @Select("select sum(b_price) from flow where u_id=#{uid} and b_time>=#{start} and b_time<#{end} and b_type=1")
    BigDecimal getExpense(@Param("uid") int uid, @Param("start") Timestamp start, @Param("end") Timestamp end);
}
