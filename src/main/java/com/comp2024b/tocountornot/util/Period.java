package com.comp2024b.tocountornot.util;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Period {
    private Timestamp start;
    private Timestamp end;
}
