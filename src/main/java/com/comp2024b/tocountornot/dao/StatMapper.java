package com.comp2024b.tocountornot.dao;

import com.comp2024b.tocountornot.util.stat.FirstStat;
import com.comp2024b.tocountornot.util.stat.MemberStat;
import com.comp2024b.tocountornot.util.stat.SecondStat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StatMapper {
    @Select("select first,sum(price) as balance from bill where uid=#{uid} and year=#{year} and type=#{type} group by first order by first desc")
    List<FirstStat> getFirstStatByYear(int uid, String year, String type);

    @Select("select first,sum(price) as balance from bill where uid=#{uid} and year=#{year} and month=#{month} and type=#{type} group by first order by first desc")
    List<FirstStat> getFirstStatByMonth(int uid, String year, String month, String type);

    @Select("select first,sum(price) as balance from bill where uid=#{uid} and year=#{year} and week=#{week} and type=#{type} group by first order by first desc")
    List<FirstStat> getFirstStatByWeek(int uid, String year, String week, String type);

    @Select("select first,sum(price) as balance from bill where uid=#{uid} and date=#{date} and type=#{type} group by first order by first desc")
    List<FirstStat> getFirstStatByDate(int uid, String date, String type);

    @Select("select first,sum(price) as balance from bill where uid=#{uid} and year=#{year} and type=#{type} and member = #{member} group by first order by first desc")
    List<FirstStat> getFirstStatByYearMember(int uid, String year, String type, String member);

    @Select("select first,sum(price) as balance from bill where uid=#{uid} and year=#{year} and month=#{month} and type=#{type} and member = #{member} group by first order by first desc")
    List<FirstStat> getFirstStatByMonthMember(int uid, String year, String month, String type, String member);

    @Select("select first,sum(price) as balance from bill where uid=#{uid} and year=#{year} and week=#{week} and type=#{type} and member = #{member} group by first order by first desc")
    List<FirstStat> getFirstStatByWeekMember(int uid, String year, String week, String type, String member);

    @Select("select first,sum(price) as balance from bill where uid=#{uid} and date=#{date} and type=#{type} and member = #{member} group by first order by first desc")
    List<FirstStat> getFirstStatByDateMember(int uid, String date, String type, String member);

    @Select("select second,sum(price) as balance from bill where uid=#{uid} and year=#{year} and type=#{type} and first=#{first} group by second order by second desc")
    List<SecondStat> getSecondStatByYear(int uid, String year, String type, String first);

    @Select("select second,sum(price) as balance from bill where uid=#{uid} and year=#{year} and month=#{month} and type=#{type} and first=#{first} group by second order by second desc")
    List<SecondStat> getSecondStatByMonth(int uid, String year, String month, String type, String first);

    @Select("select second,sum(price) as balance from bill where uid=#{uid} and year=#{year} and week=#{week} and type=#{type} and first=#{first} group by second order by second desc")
    List<SecondStat> getSecondStatByWeek(int uid, String year, String week, String type, String first);

    @Select("select second,sum(price) as balance from bill where uid=#{uid} and date=#{date} and type=#{type} and first=#{first} group by second order by second desc")
    List<SecondStat> getSecondStatByDate(int uid, String date, String type, String first);

    @Select("select member,sum(price) as balance from bill where uid=#{uid} and year=#{year} and type=#{type} group by member order by member desc")
    List<MemberStat> getMemberStatByYear(int uid, String year, String type);

    @Select("select member,sum(price) as balance from bill where uid=#{uid} and year=#{year} and month=#{month} and type=#{type} group by member order by member desc")
    List<MemberStat> getMemberStatByMonth(int uid, String year, String month, String type);

    @Select("select member,sum(price) as balance from bill where uid=#{uid} and year=#{year} and week=#{week} and type=#{type} group by member order by member desc")
    List<MemberStat> getMemberStatByWeek(int uid, String year, String week, String type);

    @Select("select member,sum(price) as balance from bill where uid=#{uid} and date=#{date} and type=#{type} group by member order by member desc")
    List<MemberStat> getMemberStatByDate(int uid, String date, String type);
}
