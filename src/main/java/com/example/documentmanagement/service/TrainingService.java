package com.example.documentmanagement.service;

import com.example.documentmanagement.model.TrainingRecord;
import com.example.documentmanagement.repository.TrainingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrainingService {

    @Autowired
    private TrainingRecordRepository trainingRecordRepository;

    public List<TrainingRecord> getAllTrainings() {
        return trainingRecordRepository.findAll();
    }

    public Optional<TrainingRecord> getTrainingById(UUID id) {
        return trainingRecordRepository.findById(id);
    }

    public TrainingRecord createTraining(TrainingRecord trainingRecord) {
        return trainingRecordRepository.save(trainingRecord);
    }

    public void deleteTraining(UUID id) {
        trainingRecordRepository.deleteById(id);
    }
}
