package com.comp2024b.tocountornot.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Component
public class Bill {
    private long id;

    @NotNull(message = "card cannot be null")
    private int card;

    @NotNull(message = "member cannot be null")
    private int member;

    @NotNull(message = "category cannot be null")
    private int category;

    @NotNull(message = "price cannot be null")
    @Digits(integer = 9, fraction = 2, message = "price should have no more than 9 integer digits or 2 decimal digits")
    @DecimalMin(value = "0.00", message = "price cannot be less than zero")
    private BigDecimal price;

    @NotNull(message = "type cannot be null")
    @Range(min=0, max=2,message = "type should be 0(income) 1(expense) or 2(transfer)")
    private int type;

    @NotNull(message = "time cannot be null")
    @Past(message = "time cannot be a future time")
    private Timestamp time;
}
