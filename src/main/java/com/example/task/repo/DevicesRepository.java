package com.example.task.repo;

import com.example.task.entity.Devices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface DevicesRepository extends JpaRepository<Devices, String> {

    Optional<Devices> findByDeviceId(String deviceId);


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Devices d SET d.lastTemperature = :lastTemperature WHERE d.deviceId = :deviceId")
    int updateDeviceLastTemperature(Integer lastTemperature, String deviceId);

}
