package com.purpletech.purplefashion.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact {

    @NotBlank(message = "Name should not be blank")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;
    @Email(message = "Please provide a valid Email address")
    @NotBlank(message = "Email should not be blank")
    private String email;
    @NotBlank(message = "Subject should not be blank")
    @Size(min = 5, message = "Subject must be at least 5 characters")
    private String subject;
    @NotBlank(message = "Message should not be blank")
    @Size(min = 10, message = "Message must be at least 10 characters")
    private String message;

}
