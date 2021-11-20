package com.leoamorimr.justremind;

import com.leoamorimr.justremind.model.Reminder;
import com.leoamorimr.justremind.repository.ReminderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class JustremindApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustremindApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ReminderRepository repository) {
        return args -> {
            repository.deleteAll();
            LongStream.range(1, 11).mapToObj(i -> {
                Reminder reminder = new Reminder();
                reminder.setSubject("Reminder: " + i);
                reminder.setContent("Content: " + i);
                return reminder;
            }).map(r -> {
                return repository.save(r);
            }).forEach(System.out::println);
        };
    }
}
