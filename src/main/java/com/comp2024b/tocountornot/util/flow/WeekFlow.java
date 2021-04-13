package com.comp2024b.tocountornot.util.flow;

import lombok.Data;

import java.util.List;

@Data
public class WeekFlow {
    private String year;
    private String week;
    private Double income;
    private Double expense;
    private List<DateFlow> list;
}
