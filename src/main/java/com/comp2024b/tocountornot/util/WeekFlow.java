package com.comp2024b.tocountornot.util;

import lombok.Data;

import java.util.List;

@Data
public class WeekFlow {
    private String year;
    private String week;
    private String income;
    private String expense;
    private List<DateFlow> list;
}
