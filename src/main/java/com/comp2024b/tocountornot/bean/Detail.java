package com.comp2024b.tocountornot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Component
public class Detail {
    private int id;
    private String card;
    private String member;
    private String category;
    private String division;
    private BigDecimal price;
    private int type;
    private Timestamp time;
}
