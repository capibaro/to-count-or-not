package com.comp2024b.tocountornot.util.flow;

import lombok.Data;
import com.comp2024b.tocountornot.bean.Bill;
import java.util.List;

@Data
public class DateFlow {
    private String date;
    private Double income;
    private Double expense;
    private List<Bill> list;
}