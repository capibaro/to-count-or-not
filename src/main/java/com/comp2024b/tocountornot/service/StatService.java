package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.dao.StatMapper;
import com.comp2024b.tocountornot.util.stat.FirstStat;
import com.comp2024b.tocountornot.util.stat.MemberStat;
import com.comp2024b.tocountornot.util.stat.SecondStat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatService {
    private final StatMapper statMapper;

    public StatService(StatMapper statMapper) {
        this.statMapper = statMapper;
    }

    public List<FirstStat> getFirstStatByYear(int uid, String year, String type) {
        return statMapper.getFirstStatByYear(uid, year, type);
    }

    public List<FirstStat> getFirstStatByMonth(int uid, String year, String month, String type) {
        return statMapper.getFirstStatByMonth(uid, year, month, type);
    }

    public List<FirstStat> getFirstStatByWeek(int uid, String year, String week, String type) {
        return statMapper.getFirstStatByWeek(uid, year, week, type);
    }

    public List<FirstStat> getFirstStatByDate(int uid, String date, String type) {
        return statMapper.getFirstStatByDate(uid, date, type);
    }

    public List<FirstStat> getFirstStatByMonthMember(int uid, String year, String month, String type, String member) {
        return statMapper.getFirstStatByMonthMember(uid, year, month, type, member);
    }

    public List<FirstStat> getFirstStatByYearMember(int uid, String year, String type, String member) {
        return statMapper.getFirstStatByYearMember(uid, year, type, member);
    }

    public List<FirstStat> getFirstStatByWeekMember(int uid, String year, String week, String type, String member) {
        return statMapper.getFirstStatByWeekMember(uid, year, week, type, member);
    }

    public List<FirstStat> getFirstStatByDateMember(int uid, String date, String type, String member) {
        return statMapper.getFirstStatByDateMember(uid, date, type, member);
    }

    public List<SecondStat> getSecondStatByMonth(int uid, String year, String month, String type, String first) {
        return statMapper.getSecondStatByMonth(uid, year, month, type, first);
    }

    public List<SecondStat> getSecondStatByYear(int uid, String year, String type, String first) {
        return statMapper.getSecondStatByYear(uid, year, type, first);
    }

    public List<SecondStat> getSecondStatByWeek(int uid, String year, String week, String type, String first) {
        return statMapper.getSecondStatByWeek(uid, year, week, type, first);
    }

    public List<SecondStat> getSecondStatByDate(int uid, String date, String type, String first) {
        return statMapper.getSecondStatByDate(uid, date, type, first);
    }
    
    public List<MemberStat> getMemberStatByMonth(int uid, String year, String month, String type) {
        return statMapper.getMemberStatByMonth(uid, year, month, type);
    }

    public List<MemberStat> getMemberStatByYear(int uid, String year, String type) {
        return statMapper.getMemberStatByYear(uid, year, type);
    }

    public List<MemberStat> getMemberStatByWeek(int uid, String year, String week, String type) {
        return statMapper.getMemberStatByWeek(uid, year, week, type);
    }

    public List<MemberStat> getMemberStatByDate(int uid, String date, String type) {
        return statMapper.getMemberStatByDate(uid, date, type);
    }
}
