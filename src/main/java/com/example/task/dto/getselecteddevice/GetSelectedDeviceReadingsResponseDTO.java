package com.example.task.dto.getselecteddevice;

import com.example.task.entity.DevicesReadings;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class GetSelectedDeviceReadingsResponseDTO {
    private List<ReadingsDTO> readingsDTOS;

    public GetSelectedDeviceReadingsResponseDTO(List<DevicesReadings> temperatureList) {
        this.setReadingsDTOS(temperatureList.stream().map(ReadingsDTO::new)
                .collect(Collectors.toList()));
    }
}
