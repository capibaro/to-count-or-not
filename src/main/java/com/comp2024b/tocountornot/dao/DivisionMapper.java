package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Division;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DivisionMapper {
    @Insert("insert into division (d_id,u_id,d_name) values (#{id},#{user},#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "d_id", keyProperty = "id")
    void insertDivision(Division division);

    @Delete("delete from division where d_id=#{id}")
    void deleteDivision(@Param("id") int id);

    @Update("update division set d_name=#{name} where d_id=#{id}")
    void updateDivision(Division division);

    @Select("select d_id as id,d_name as name from division where d_id=#{id} and u_id=#{uid}")
    Division getDivisionById(@Param("id") int id, @Param("uid") int uid);

    @Select("select d_id as id,d_name as name from division where u_id=#{uid}")
    List<Division> getAllDivision(@Param("uid") int uid);
}
