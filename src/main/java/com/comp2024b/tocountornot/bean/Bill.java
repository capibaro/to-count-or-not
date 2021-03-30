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

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateYear() {
        return date_year;
    }

    public void setDateYear(String date_year) {
        this.date_year = date_year;
    }

    public String getDateMonth() {
        return date_month;
    }

    public void setDateMonth(String date_month) {
        this.date_month = date_month;
    }

    public String getDateWeek() {
        return date_week;
    }

    public void setDateWeek(String date_week) {
        this.date_week = date_week;
    }

    public String getInOrOut() {
        return in_or_out;
    }

    public void setInOrOut(String in_or_out) {
        this.in_or_out = in_or_out;
    }
}
