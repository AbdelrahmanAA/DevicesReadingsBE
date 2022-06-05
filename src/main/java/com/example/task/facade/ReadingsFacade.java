package com.example.task.facade;

import com.example.task.dto.addtemperature.AddTemperatureRequestDTO;
import com.example.task.dto.common.APIResponse;
import com.example.task.dto.getalldevices.GetAllDevicesResponseDTO;
import com.example.task.dto.getselecteddevice.GetSelectedDeviceReadingRequestDTO;
import com.example.task.dto.getselecteddevice.GetSelectedDeviceReadingsResponseDTO;
import com.example.task.entity.Devices;
import com.example.task.entity.DevicesReadings;
import com.example.task.enums.ConstEnum;
import com.example.task.service.DevicesService;
import com.example.task.service.ReadingsTemperatureService;
import com.example.task.util.APIResponseGenerator;
import com.example.task.util.ObjectUtil;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Component
public class ReadingsFacade {

    private final ReadingsTemperatureService readingsTemperatureService;
    private final DevicesService devicesService;

    public ReadingsFacade(ReadingsTemperatureService readingsTemperatureService, DevicesService devicesService) {
        this.readingsTemperatureService = readingsTemperatureService;
        this.devicesService = devicesService;
    }

    public APIResponse addNewReadings(AddTemperatureRequestDTO requestDTO) {
        String inputLine = requestDTO.getInputLine();
        if (ObjectUtil.isNullOrEmpty(inputLine)) {
            return APIResponseGenerator.generateMissingRequiredFieldsFailureResponse();
        }
        boolean res = this.processIncomingReadings(inputLine);
        if (!res) {
            return APIResponseGenerator.generateInvalidLengthFailureResponse();
        }
        return APIResponseGenerator.generateSuccessResponse(null);
    }

    private boolean processIncomingReadings(String inputLine) {
        inputLine = inputLine.trim().substring(2);
        int dataLength = ConstEnum.DEVICE_ID_LENGTH.getValue() +
                ConstEnum.TEMPERATURE_LENGTH.getValue();
        if (inputLine.length() % dataLength == 0) {
            String[] splitData = inputLine.split("(?<=\\G.{" + dataLength + "})");
            for (String readingsData : splitData) {
                Object[] res = this.extractReadingValues(readingsData);
                String deviceId = String.valueOf(res[0]);
                Integer lastTemperature = (Integer) res[1];
                Optional<Devices> device = this.devicesService
                        .findDeviceByDeviceID(deviceId);
                Devices selectedDevice;
                if (device.isPresent()) {
                    selectedDevice = device.get();
                    selectedDevice.setLastTemperature(lastTemperature);
                } else {
                    selectedDevice = new Devices(deviceId, lastTemperature);
                }
                selectedDevice = this.devicesService.saveDevice(selectedDevice);
                DevicesReadings devicesReadings = new DevicesReadings(selectedDevice);
                this.readingsTemperatureService.addNewDeviceTemperature(devicesReadings);
            }
            return true;
        }
        return false;
    }

    private Object[] extractReadingValues(String readingsData) {
        Object[] res = new Object[2];
        // res[0] = device ID
        // res[1] = temperature
        String hexDeviceId = readingsData.substring(0, ConstEnum.DEVICE_ID_LENGTH.getValue());
        String hexTemperature = readingsData.substring(ConstEnum.DEVICE_ID_LENGTH.getValue());
        res[0] = new BigInteger(hexDeviceId, 16);
        res[1] = Integer.parseInt(hexTemperature, 16);


        return res;
    }

    public APIResponse getSelectedReadingInfo(GetSelectedDeviceReadingRequestDTO
                                                      requestDTO) {
        String deviceId = requestDTO.getDeviceId();
        if (ObjectUtil.isNullOrEmpty(deviceId)) {
            return APIResponseGenerator.generateMissingRequiredFieldsFailureResponse();
        }
        List<DevicesReadings> readingsList = readingsTemperatureService.findByDeviceId(deviceId);
        if (ObjectUtil.isNullOrEmpty(readingsList)) {
            return APIResponseGenerator.generateNoDataFoundFailureResponse();
        }
        GetSelectedDeviceReadingsResponseDTO getSelectedDeviceReadingsResponseDTO =
                new GetSelectedDeviceReadingsResponseDTO(readingsList);
        return APIResponseGenerator.generateSuccessResponse(getSelectedDeviceReadingsResponseDTO);
    }

    public APIResponse getAllDevicesList() {
        List<Devices> allDevices = devicesService.findAllDevices();
        if (ObjectUtil.isNullOrEmpty(allDevices)) {
            return APIResponseGenerator.generateNoDataFoundFailureResponse();
        }
        GetAllDevicesResponseDTO getAllDevicesResponseDTO = new GetAllDevicesResponseDTO(allDevices);
        return APIResponseGenerator.generateSuccessResponse(getAllDevicesResponseDTO);
    }
}