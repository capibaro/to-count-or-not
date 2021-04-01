package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from user where name = #{name}")
    User selectUserByName(@Param("name") String name);

    @Insert("insert into user values(#{uid},#{name},#{password})")
    void insertUser(@Param("uid") Long uid, @Param("name") String name, @Param("password") String password);

    @Update("update user set name=#{name},password=#{password} where uid=#{uid}")
    void updateUser(@Param("name") String name, @Param("password") String password, @Param("uid") Long uid);

    @Delete("delete from user where uid=#{uid}")
    void deleteUser(@Param("uid") Long uid);
}