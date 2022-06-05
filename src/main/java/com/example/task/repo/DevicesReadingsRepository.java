package com.example.task.repo;

import com.example.task.entity.DevicesReadings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DevicesReadingsRepository extends JpaRepository<DevicesReadings, String> {

    @Query("select d from DevicesReadings d where d.device.deviceId = :deviceId")
    List<DevicesReadings> loadAllReadingsByDeviceId(String deviceId);
}
