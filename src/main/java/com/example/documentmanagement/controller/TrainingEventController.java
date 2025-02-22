package com.example.documentmanagement.controller;

import com.example.documentmanagement.model.TrainingEvent;
import com.example.documentmanagement.service.TrainingEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController  // ✅ Ensure this annotation is present
@RequestMapping("/training-events")  // ✅ Ensure mapping is correct
public class TrainingEventController {

    @Autowired
    private TrainingEventService trainingEventService;

    @GetMapping  // ✅ This maps GET /training-events
    public List<TrainingEvent> getAllTrainingEvents() {
        return trainingEventService.getAllTrainings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingEvent> getTrainingById(@PathVariable UUID id) {
        TrainingEvent trainingEvent = trainingEventService.getTrainingById(id);  // ✅ No need for Optional now
        return ResponseEntity.ok(trainingEvent);
    }
}
