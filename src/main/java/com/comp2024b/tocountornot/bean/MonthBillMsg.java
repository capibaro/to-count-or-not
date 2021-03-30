package com.comp2024b.tocountornot.bean;

import java.util.List;

public class MonthBillMsg extends Msg {

    private String income;
    private String expense;
    private List<DayBillMsg> bill_list;

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public List<DayBillMsg> getBill_list() {
        return bill_list;
    }

    public void setBillList(List<DayBillMsg> bill_list) {
        this.bill_list = bill_list;
    }

    public static class DayBillMsg {

        private String date;
        private String income;
        private String expense;
        private List<Bill> bill_list;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getIncome() {
            return income;
        }

        public void setIncome(String income) {
            this.income = income;
        }

        public String getExpense() {
            return expense;
        }

        public void setExpense(String expense) {
            this.expense = expense;
        }

        public List<Bill> getBillList() {
            return bill_list;
        }

        public void setBillList(List<Bill> bill_list) {
            this.bill_list = bill_list;
        }
    }
}