package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.bean.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FlowMapper {
    @Select("select * from bill where uid=#{uid} and date=#{date}")
    List<Bill> getBillByDate(int uid, String date);

    @Select("select distinct date from bill where uid=#{uid} and year=#{year} and month=#{month} order by date")
    List<String> getDateInMonth(int uid, String year, String month);

    @Select("select distinct date from bill where uid=#{uid} and year=#{year} and week=#{week} order by date")
    List<String> getDateInWeek(int uid, String year, String week);

    @Select("select sum(price) from bill where uid=#{uid} and date=#{date} and type='in' group by uid")
    String getIncomeByDate(int uid, String date);

    @Select("select sum(price) from bill where uid=#{uid} and date=#{date} and type='out' group by uid")
    String getExpenseByDate(int uid, String date);

    @Select("select sum(price) from bill where uid=#{uid} and year=#{year} and week=#{week} and type='in' group by uid")
    String getIncomeByWeek(int uid, String year, String week);

    @Select("select sum(price) from bill where uid=#{uid} and year=#{year} and week=#{week} and type='out' group by uid")
    String getExpenseByWeek(int uid, String year, String week);

    @Select("select sum(price) from bill where uid=#{uid} and year=#{year} and month=#{month} and type='in' group by uid")
    String getIncomeByMonth(int uid, String year, String month);

    @Select("select sum(price) from bill where uid=#{uid} and year=#{year} and month=#{month} and type='out' group by uid")
    String getExpenseByMonth(int uid, String year, String month);
}
