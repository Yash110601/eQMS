package com.example.documentmanagement.controller;

import com.example.documentmanagement.model.TrainingRecord;
import com.example.documentmanagement.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping
    public List<TrainingRecord> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

    @GetMapping("/{id}")
    public Optional<TrainingRecord> getTrainingById(@PathVariable UUID id) {
        return trainingService.getTrainingById(id);
    }

    @PostMapping
    public TrainingRecord createTraining(@RequestBody TrainingRecord trainingRecord) {
        return trainingService.createTraining(trainingRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteTraining(@PathVariable UUID id) {
        trainingService.deleteTraining(id);
    }
}
