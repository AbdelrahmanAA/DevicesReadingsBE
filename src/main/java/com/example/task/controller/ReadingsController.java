package com.example.task.controller;

import com.example.task.dto.addtemperature.AddTemperatureRequestDTO;
import com.example.task.dto.getselecteddevice.GetSelectedDeviceReadingRequestDTO;
import com.example.task.facade.ReadingsFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/readings")
public class ReadingsController {
    private final ReadingsFacade readingsFacade;


    public ReadingsController(ReadingsFacade readingsFacade) {
        this.readingsFacade = readingsFacade;
    }

    @PostMapping("/addNewReadings")
    public ResponseEntity<?> addNewReadings(@RequestBody AddTemperatureRequestDTO readingsLine) {
        return ResponseEntity.ok(readingsFacade.addNewReadings(readingsLine));
    }

    @GetMapping("/getAllDevicesList")
    public ResponseEntity<?> getAllDevicesList() {
        return ResponseEntity.ok(readingsFacade.getAllDevicesList());
    }

    @PostMapping("/getSelectedDeviceReadingList")
    public ResponseEntity<?> getSelectedDeviceReadingList(@RequestBody GetSelectedDeviceReadingRequestDTO getSelectedDeviceReadingRequestDTO) {
        return ResponseEntity.ok(readingsFacade.getSelectedReadingInfo(getSelectedDeviceReadingRequestDTO));
    }
}
