package com.comp2024b.tocountornot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Bill {
    private Long id;
    private String first;
    private String second;
    private Double price;
    private String card;
    private String member;
    private String date;
    private String year;
    private String month;
    private String week;
    private String type;
    private Integer uid;
}
