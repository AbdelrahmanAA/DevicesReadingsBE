package com.example.task.dto.getalldevices;

import com.example.task.entity.Devices;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeviceDTO {
    private String deviceId;
    private Integer temperature;

    public DeviceDTO(Devices device) {
        this.deviceId = device.getDeviceId();
        this.temperature = device.getLastTemperature();
    }
}
