package com.leoamorimr.justremind;

import com.leoamorimr.justremind.model.Reminder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class JustremindApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustremindApplication.class, args);
    }

    @GetMapping
    public List<Reminder> reminder() {
        return List.of(new Reminder(1L, "Take the pill", "Remember to take the pill"));
    }
}
