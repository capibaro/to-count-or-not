package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Bill;
import com.comp2024b.tocountornot.bean.Member;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {
    @Insert("insert into member (m_id,u_id,m_name) values (#{id},#{user},#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "m_id", keyProperty = "id")
    void insertMember(Member member);

    @Delete("delete from member where m_id=#{id}")
    void deleteMember(@Param("id") int id);

    @Update("update member set m_name=#{name} where m_id=#{id}")
    void updateMember(Member member);

    @Select("select m_id as id,m_name as name from member where m_id=#{id} and u_id=#{uid}")
    Member getMemberById(@Param("id") int id, @Param("uid") int uid);

    @Select("select m_id as id,m_name as name from member where u_id=#{uid}")
    List<Member> getAllMember(@Param("uid") int uid);

    @Select("select b_id as id,c_id as card,m_id as member,ca_id as category,b_price as price,b_type as type, " +
            "b_time as time from bill where m_id=#{id}")
    List<Bill> getBillByMember(@Param("id") int id);
}
