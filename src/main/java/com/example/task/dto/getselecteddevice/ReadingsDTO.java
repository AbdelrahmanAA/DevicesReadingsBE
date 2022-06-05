package com.example.task.dto.getselecteddevice;

import com.example.task.entity.DevicesReadings;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ReadingsDTO {
    private String deviceId;
    private Integer temperature;
    private Date creationDate;

    public ReadingsDTO(DevicesReadings devicesReadings) {
        this.deviceId = devicesReadings.getDevice().getDeviceId();
        this.temperature = devicesReadings.getReadings();
        this.creationDate = devicesReadings.getCreatedAt();
    }
}
