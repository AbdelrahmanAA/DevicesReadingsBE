package com.example.task.service;


import com.example.task.entity.DevicesReadings;
import com.example.task.repo.DevicesReadingsRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ReadingsTemperatureService {

    private final DevicesReadingsRepository devicesReadingsRepository;

    public ReadingsTemperatureService(DevicesReadingsRepository devicesReadingsRepository) {
        this.devicesReadingsRepository = devicesReadingsRepository;
    }

    public List<DevicesReadings> findByDeviceId(String deviceId) {
        return devicesReadingsRepository.loadAllReadingsByDeviceId(deviceId);
    }

    public void addNewDeviceTemperature(DevicesReadings devicesReadings) {
        this.devicesReadingsRepository.save(devicesReadings);
    }

}
