package com.leoamorimr.justremind.controller;

import com.leoamorimr.justremind.model.Reminder;
import com.leoamorimr.justremind.repository.ReminderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/justremind/api/")
public class ReminderController {

    private ReminderRepository repository;

    public ReminderController(ReminderRepository reminderRepository) {
        this.repository = reminderRepository;
    }

    @GetMapping()
    public List<Reminder> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity findReminder(@PathVariable Long id) {
        return repository.findById(id).map(reminder -> ResponseEntity.ok().body(reminder)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public Reminder createReminder(@Valid @RequestBody Reminder reminder) {
        return repository.save(reminder);
    }

    @PutMapping("{id}")
    public ResponseEntity updateReminder(@Valid @PathVariable Long id, @RequestBody Reminder reminder) {
        return repository.findById(id).map(record -> {
            record.setSubject(reminder.getSubject());
            record.setContent(reminder.getContent());
            Reminder updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteReminder(@PathVariable Long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
