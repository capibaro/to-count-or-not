package com.comp2024b.tocountornot.util;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.sql.Timestamp;

@Data
public class Period {

    @NotNull(message = "start time cannot be null")
    @Past(message = "start time cannot be a future time")
    private Timestamp start;

    @NotNull(message = "end time cannot be null")
    @Past(message = "end time cannot be a future time")
    private Timestamp end;
}
