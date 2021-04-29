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

    @Select("select * from bill where uid=#{uid} and date=#{date} and card=#{card}")
    List<Bill> getBillByDateCard(int uid, String date, String card);

    @Select("select distinct date from bill where uid=#{uid} and year=#{year} and month=#{month} and card=#{card} order by date")
    List<String> getDateInMonthByCard(int uid, String year, String month, String card);

    @Select("select distinct date from bill where uid=#{uid} and year=#{year} and week=#{week} and card=#{card} order by date")
    List<String> getDateInWeekByCard(int uid, String year, String week, String card);

    @Select("select sum(price) from bill where uid=#{uid} and date=#{date} and type=#{type} and card=#{card} group by uid")
    Double getBalanceByDateCard(int uid, String date, String type, String card);

    @Select("select sum(price) from bill where uid=#{uid} and year=#{year} and week=#{week} and type=#{type} and card=#{card} group by uid")
    Double getBalanceByWeekCard(int uid, String year, String week, String type, String card);

    @Select("select sum(price) from bill where uid=#{uid} and year=#{year} and month=#{month} and type=#{type} and card=#{card} group by uid")
    Double getBalanceByMonthCard(int uid, String year, String month, String type, String card);
}
