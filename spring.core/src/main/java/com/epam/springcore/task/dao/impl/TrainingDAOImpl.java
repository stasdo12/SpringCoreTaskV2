package com.epam.springcore.task.dao.impl;

import com.epam.springcore.task.dao.TrainingDAO;
import com.epam.springcore.task.model.Training;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TrainingDAOImpl implements TrainingDAO {

    private Map<Long, Training> trainingsStorage;


    @Autowired
    public TrainingDAOImpl(Map<Long, Training> trainingsStorage) {
        this.trainingsStorage = trainingsStorage;
    }


    @Override
    public Optional<Training> create(long trainingId, Training training) {
        trainingsStorage.put(trainingId, training);
        return getById(trainingId);
    }

    @Override
    public Optional<Training> getById(long trainingId) {
        return Optional.ofNullable(trainingsStorage.get(trainingId));
    }

    @Override
    public List<Training> getAllTrainings() {
        return new ArrayList<>(trainingsStorage.values());
    }

    @Override
    public long getMaxId() {
        return trainingsStorage.keySet().stream().max(Long::compareTo).orElse(0L) +1;
    }
}
