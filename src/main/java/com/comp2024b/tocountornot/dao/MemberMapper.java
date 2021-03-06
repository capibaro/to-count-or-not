package com.comp2024b.tocountornot.dao;

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

    @Select("select m_id as id,m_name as name from member where u_id=#{id} limit 1")
    Member getMemberByUser(@Param("id") int id);
}
