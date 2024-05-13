package io.dowlath.publishconsumemessges.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage {
    private Date timeStamp;
    private String message;
    private String details;

}
