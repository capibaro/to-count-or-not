package com.comp2024b.tocountornot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Component
public class User {
    private int id;

    @NotBlank(message = "name cannot be blank")
    @Size(max = 20, message = "name length cannot exceed 20")
    private String name;

    @NotBlank(message = "password cannot be blank")
    private String password;

    private String salt;
}
