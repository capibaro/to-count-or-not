package com.comp2024b.tocountornot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Component
public class Category {
    private int id;

    @NotNull(message = "division cannot be null")
    private int division;

    @NotBlank(message = "name cannot be blank")
    @Size(max = 10, message = "name length cannot exceed 10")
    private String name;
}
