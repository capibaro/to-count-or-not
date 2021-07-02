package com.comp2024b.tocountornot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Data
@Component
public class Flow {
    private BigDecimal income;
    private BigDecimal expense;
    private List<Detail> details;
}
