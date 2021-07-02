package com.comp2024b.tocountornot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Component
public class Division {
    private int id;
    private int user;

    @NotBlank(message = "name cannot be blank")
    @Size(max = 10, message = "name length cannot exceed 10")
    private String name;
}
