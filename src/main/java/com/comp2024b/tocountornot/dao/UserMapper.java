package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into usr (u_id,u_name,u_password,u_salt) values(#{id},#{name},#{password},#{salt})")
    @Options(useGeneratedKeys = true, keyColumn = "u_id", keyProperty = "id")
    void insertUser(User user);

    @Delete("delete from usr where u_id=#{id}")
    void deleteUser(@Param("id") int id);

    @Update("update usr set u_password=#{password},u_salt=#{salt} where u_id=#{id}")
    void updateUser(User user);

    @Select("select u_id as id,u_name as name,u_password as password,u_salt as salt from usr where u_name=#{name}")
    User getUserByName(@Param("name") String name);

    @Select("select u_id as id,u_name as name,u_password as password,u_salt as salt from usr where u_id=#{id}")
    User getUserById(@Param("id") int id);
}