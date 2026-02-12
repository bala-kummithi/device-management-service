package com.demo.device.controller;



import com.demo.device.dto.DeviceRequest;
import com.demo.device.model.DeviceRegistration;
import com.demo.device.repository.DeviceRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Device")
public class DeviceController {

    private final DeviceRepository repository;

    public DeviceController(DeviceRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody DeviceRequest request) {

        if (request.getUserKey() == null || request.getDeviceType() == null) {
            return ResponseEntity.badRequest()
                    .body(new StatusResponse(400));
        }

        DeviceRegistration entity = new DeviceRegistration();
        entity.setUserKey(request.getUserKey().trim());
        entity.setDeviceType(request.getDeviceType().toUpperCase());

        repository.save(entity);

        return ResponseEntity.ok(new StatusResponse(200));
    }

    record StatusResponse(int statusCode) {}
}
