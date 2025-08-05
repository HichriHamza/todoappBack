// src/main/java/app/todo/todoapp/dto/RegisterRequest.java
package app.todo.todoapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    // Getters and Setters
    @NotBlank(message = "Name is required")
    private String name;


    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    // Default constructor (required for Jackson)
    public RegisterRequest() {}

    // Constructor with fields (optional)
    public RegisterRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
