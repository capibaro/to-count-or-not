package com.comp2024b.tocountornot.bean;

import lombok.Data;

@Data
public class Bill {
    private long id;
    private String first;
    private String second;
    private double price;
    private String card;
    private String member;
    private String date;
    private String year;
    private String month;
    private String week;
    private String type;
    private int uid;
}
