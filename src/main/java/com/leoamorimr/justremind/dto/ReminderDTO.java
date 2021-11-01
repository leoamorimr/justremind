package com.leoamorimr.justremind.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor

public class ReminderDTO implements Serializable {
    private Long id;

    @NotEmpty(message = "Field mandatory!")
    private String subject;
    @NotEmpty(message = "Field mandatory!")
    private String content;


}
