package com.comp2024b.tocountornot.util;

import lombok.Data;

import java.util.List;

@Data
public class MonthFlow {
    private String year;
    private String month;
    private String income;
    private String expense;
    private List<DateFlow> list;
}
