package com.comp2024b.tocountornot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class Balance {
    private int id;
    private String name;
    private BigDecimal price;
}
