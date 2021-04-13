package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FlowMapper {
    @Select("select * from bill where uid=#{uid} and date=#{date}")
    List<Bill> getBillByDate(int uid, String date);

    @Select("select distinct date from bill where uid=#{uid} and year=#{year} and month=#{month} order by date")
    List<String> getDateInMonth(int uid, String year, String month);

    @Select("select distinct date from bill where uid=#{uid} and year=#{year} and week=#{week} order by date")
    List<String> getDateInWeek(int uid, String year, String week);

    @Select("select sum(price) from bill where uid=#{uid} and date=#{date} and type=#{type} group by uid")
    Double getBalanceByDate(int uid, String date, String type);

    @Select("select sum(price) from bill where uid=#{uid} and year=#{year} and week=#{week} and type=#{type} group by uid")
    Double getBalanceByWeek(int uid, String year, String week, String type);

    @Select("select sum(price) from bill where uid=#{uid} and year=#{year} and month=#{month} and type=#{type} group by uid")
    Double getBalanceByMonth(int uid, String year, String month, String type);
}
