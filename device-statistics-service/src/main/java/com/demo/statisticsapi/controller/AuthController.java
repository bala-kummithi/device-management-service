package com.demo.statisticsapi.controller;

import com.demo.statisticsapi.dto.DeviceRequest;
import com.demo.statisticsapi.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Log/auth")
public class AuthController {

    private final RestTemplate restTemplate;
    private final DeviceRepository repository;

    @Value("${device.api.url}")
    private String deviceApiUrl;

    public AuthController(RestTemplate restTemplate,
                          DeviceRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> log(@RequestBody DeviceRequest request) {

        try {
            restTemplate.postForEntity(
                    deviceApiUrl + "/Device/register",
                    request,
                    Object.class);

            return ResponseEntity.ok(
                    new AuthResponse(200, "success"));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new AuthResponse(400, "bad_request"));
        }
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> statistics(
             @RequestParam("deviceType") String deviceType) {

        if (deviceType == null || deviceType.isBlank()) {
            return ResponseEntity.ok(
                    new StatsResponse(deviceType, -1));
        }

        long count = repository
                .countByDeviceType(deviceType.toUpperCase());

        return ResponseEntity.ok(
                new StatsResponse(deviceType.toUpperCase(), count));
    }

    record AuthResponse(int statusCode, String message) {}
    record StatsResponse(String deviceType, long count) {}
}
