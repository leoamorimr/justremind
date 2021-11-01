package com.leoamorimr.justremind.controller;

import com.leoamorimr.justremind.model.Reminder;
import com.leoamorimr.justremind.service.ReminderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/justremind")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping()
    public List<Reminder> findAll() {
        return reminderService.findAllReminders();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findReminder(@PathVariable Long id) {
        return reminderService.findReminder(id).map(reminder -> ResponseEntity.ok().body(reminder)).orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public ResponseEntity<?> createReminder(@Valid @RequestBody ReminderDTO reminderDTO) {
//        return reminderService.create();
//    }

}
