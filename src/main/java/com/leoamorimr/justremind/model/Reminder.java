package com.leoamorimr.justremind.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reminder {
    @Id
    private Long id;
    private String subject;
    private String content;
}
