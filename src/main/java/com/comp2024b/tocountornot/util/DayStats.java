package com.comp2024b.tocountornot.util;

import lombok.Data;
import com.comp2024b.tocountornot.bean.Bill;
import java.util.List;

@Data
public class DayStats {
    private String date;
    private String income;
    private String expense;
    private List<Bill> list;
}