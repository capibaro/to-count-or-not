package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    @Insert("insert into category (ca_id,d_id,ca_name) values (#{id},#{division},#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "ca_id", keyProperty = "id")
    void insertCategory(Category category);

    @Delete("delete from category where ca_id=#{id}")
    void deleteCategory(@Param("id") int id);

    @Update("update category set ca_name=#{name} where ca_id=#{id}")
    void updateCategory(Category category);

    @Select("select ca_id as id,d_id as division,ca_name as name from category inner join division using(d_id) " +
            "where ca_id=#{id} and u_id=#{uid};")
    Category getCategoryById(@Param("id") int id, @Param("uid") int uid);

    @Select("select ca_id as id,d_id as division,ca_name as name from category inner join division using(d_id) " +
            "where d_id=#{did} and u_id=#{uid};")
    List<Category> getCategoriesByDivision(@Param("did") int did, @Param("uid") int uid);
}
