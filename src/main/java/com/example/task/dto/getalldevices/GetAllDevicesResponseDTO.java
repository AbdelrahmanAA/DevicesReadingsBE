package com.example.task.dto.getalldevices;

import com.example.task.entity.Devices;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class GetAllDevicesResponseDTO {
    private List<DeviceDTO> deviceDTOList;

    public GetAllDevicesResponseDTO(List<Devices> allDevices) {
        this.setDeviceDTOList(allDevices.stream().map(DeviceDTO::new)
                .collect(Collectors.toList()));
    }
}
