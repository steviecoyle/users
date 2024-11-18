package com.scoyle.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto implements Serializable {

    @NotNull(message = "Forename cannot be null")
    private String forename;

    @NotNull(message = "Surname cannot be null")
    private String surname;

    @NotNull(message = "Username cannot be null")
    private String userName;

    @NotNull(message = "Email address cannot be null")
    @Email(message = "")
    private String emailAddress;

    @NotNull(message = "Password cannot be null")
    private String password;
}
