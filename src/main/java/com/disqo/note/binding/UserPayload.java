package com.disqo.note.binding;

import javax.validation.constraints.*;

public class UserPayload {
    @Email(message = "Email field must be a valid email format")
    @NotBlank(message = "Username can not be a null")
    @NotNull(message = "Username can not be a blank")
    private String email;

    @NotNull(message = "Password can not be a null")
    @NotBlank(message = "Password can not be a blank")
    @Size(min = 8, message = "Password must be at least 8 character")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
