package com.leoamorimr.justremind.controller;

import com.leoamorimr.justremind.dto.ReminderDTO;
import com.leoamorimr.justremind.model.Reminder;
import com.leoamorimr.justremind.service.ReminderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping
    public ResponseEntity<?> createReminder(@Valid @RequestBody ReminderDTO reminderDTO) {
        Reminder reminder = reminderService.fromDTO(reminderDTO);
        reminder = reminderService.create(reminder);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reminderDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long id) {
        reminderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Void> updateReminder(@Valid @PathVariable Long id, @RequestBody ReminderDTO reminderDTO) {
        Reminder reminder = reminderService.fromDTO(reminderDTO);
        reminder.setId(id);
        reminderService.update(reminder);

        return ResponseEntity.noContent().build();
    }

}
