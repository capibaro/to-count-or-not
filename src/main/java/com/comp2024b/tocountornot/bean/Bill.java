package com.comp2024b.tocountornot.bean;

public class Bill {
    private long id;
    private String first;
    private String second;
    private double price;
    private String card;
    private String member;
    private String date;
    private String date_year;
    private String date_month;
    private String date_week;
    private String in_or_out;

    public long getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public double getPrice() {
        return price;
    }

    public String getCard() {
        return card;
    }

    public String getMember() {
        return member;
    }

    public String getDate() {
        return date;
    }

    public String getDate_year() {
        return date_year;
    }

    public String getDate_month() {
        return date_month;
    }

    public String getDate_week() {
        return date_week;
    }

    public String getIn_or_out() {
        return in_or_out;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDate_year(String date_year) {
        this.date_year = date_year;
    }

    public void setDate_month(String date_month) {
        this.date_month = date_month;
    }

    public void setDate_week(String date_week) {
        this.date_week = date_week;
    }

    public void setIn_or_out(String in_or_out) {
        this.in_or_out = in_or_out;
    }
}
