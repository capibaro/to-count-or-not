package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where name = #{name}")
    User selectUserByName(@Param("name") String name);

    @Delete("delete from user where id=#{id}")
    void deleteUser(@Param("id") int id);

    @Insert("insert into user values(#{id},#{name},#{password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertUser(User user);

    @Update("update user set name=#{name},password=#{password} where id=#{id}")
    void updateUser(User user);
}