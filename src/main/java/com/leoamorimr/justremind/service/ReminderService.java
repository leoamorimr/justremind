package com.leoamorimr.justremind.service;

import com.leoamorimr.justremind.model.Reminder;
import com.leoamorimr.justremind.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderService {
    private final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public List<Reminder> findAllReminders() {
        return reminderRepository.findAll();
    }

    public Optional<Reminder> findReminder(Long id) {
        return reminderRepository.findById(id);
    }

    public Reminder create(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

}
