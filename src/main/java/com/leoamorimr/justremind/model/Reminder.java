package com.leoamorimr.justremind.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Reminder {
    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "reminder_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pk_sequence")
    private Long id;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String content;
}
