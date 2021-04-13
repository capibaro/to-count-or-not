package com.comp2024b.tocountornot.util.flow;

import lombok.Data;

import java.util.List;

@Data
public class MonthFlow {
    private String year;
    private String month;
    private Double income;
    private Double expense;
    private List<DateFlow> list;
}
