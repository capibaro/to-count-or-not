package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Balance;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface BalanceMapper {
    @Select("select c_id as id,c_name as name,sum(b_price) as price from card_balance where u_id=#{uid} " +
            "and b_type=#{type} and b_time>=#{start} and b_time<#{end} group by c_id")
    List<Balance> getCardBalance(@Param("uid") int uid, @Param("type") int type, @Param("start") Timestamp start,
                                 @Param("end") Timestamp end);

    @Select("select m_id as id,m_name as name,sum(b_price) as price from member_balance where u_id=#{uid} " +
            "and b_type=#{type} and b_time>=#{start} and b_time<#{end} group by m_id")
    List<Balance> getMemberBalance(@Param("uid") int uid, @Param("type") int type, @Param("start") Timestamp start,
                                   @Param("end") Timestamp end);

    @Select("select d_id as id,d_name as name,sum(b_price) as price from division_balance where u_id=#{uid} " +
            "and b_type=#{type} and b_time>=#{start} and b_time<#{end} group by d_id")
    List<Balance> getDivisionBalance(@Param("uid") int uid, @Param("type") int type, @Param("start") Timestamp start,
                                     @Param("end") Timestamp end);

    @Select("select ca_id as id,ca_name as name,sum(b_price) as price from category_balance where d_id=#{division} " +
            "and b_type=#{type} and b_time>=#{start} and b_time<#{end} group by ca_id")
    List<Balance> getCategoryBalance(@Param("division") int division, @Param("type") int type, @Param("start") Timestamp start,
                                     @Param("end") Timestamp end);
}
