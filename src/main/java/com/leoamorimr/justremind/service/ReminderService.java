package com.leoamorimr.justremind.service;

import com.leoamorimr.justremind.dto.ReminderDTO;
import com.leoamorimr.justremind.model.Reminder;
import com.leoamorimr.justremind.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderService {
    private final ReminderRepository repo;

    public ReminderService(ReminderRepository reminderRepository) {
        this.repo = reminderRepository;
    }

    public List<Reminder> findAllReminders() {
        return repo.findAll();
    }

    public Optional<Reminder> findReminder(Long id) {
        return repo.findById(id);
    }

    public Reminder create(Reminder reminder) {
        reminder.setId(null);
        return repo.save(reminder);
    }

    public Reminder fromDTO(ReminderDTO reminderDTO) {
        return new Reminder(reminderDTO.getId(), reminderDTO.getSubject(), reminderDTO.getContent());
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void update(Reminder reminder) {
        repo.save(reminder);
    }
}
