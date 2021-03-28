package com.comp2024b.tocountornot.bean;

import java.util.List;

public class MonthBillList extends Base{
    private String month_income; // 本月总收入
    private String month_outcome; // 本月总支出
    private List<DayBillList> dayList; //本月的日记录

    public String getMonth_income() {
        return month_income;
    }

    public void setMonth_income(String month_income) {
        this.month_income = month_income;
    }

    public String getMonth_outcome() {
        return month_outcome;
    }

    public void setMonth_outcome(String month_outcome) {
        this.month_outcome = month_outcome;
    }

    public List<DayBillList> getDayList() {
        return dayList;
    }

    public void setDayList(List<DayBillList> dayList) {
        this.dayList = dayList;
    }

    public static class DayBillList {
        private String date; // 日期
        private String day_income; // 本日总收入
        private String day_outcome; // 本日总支出
        private List<Bill> list; //本日记录

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDay_income() {
            return day_income;
        }

        public void setDay_income(String day_income) {
            this.day_income = day_income;
        }

        public String getDay_outcome() {
            return day_outcome;
        }

        public void setDay_outcome(String day_outcome) {
            this.day_outcome = day_outcome;
        }

        public List<Bill> getList() {
            return list;
        }

        public void setList(List<Bill> list) {
            this.list = list;
        }
    }
}