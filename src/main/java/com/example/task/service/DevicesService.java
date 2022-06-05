package com.example.task.service;


import com.example.task.entity.Devices;
import com.example.task.repo.DevicesRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class DevicesService {

    private final DevicesRepository devicesRepository;

    public DevicesService(DevicesRepository devicesRepository) {
        this.devicesRepository = devicesRepository;
    }

    public List<Devices> findAllDevices() {
        return devicesRepository.findAll();
    }

    public Optional<Devices> findDeviceByDeviceID(String deviceId) {
        return this.devicesRepository.findByDeviceId(deviceId);
    }


    public Devices saveDevice(Devices devices) {
       return this.devicesRepository.save(devices);
    }

    public int getDeviceByDeviceId(String deviceId, Integer lastTemperature) {
        return this.devicesRepository.updateDeviceLastTemperature(lastTemperature, deviceId);
    }
}
