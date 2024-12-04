package com.scoyle.users.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericErrorResponse implements Serializable {

    private String timestamp;
    private String message;
}
