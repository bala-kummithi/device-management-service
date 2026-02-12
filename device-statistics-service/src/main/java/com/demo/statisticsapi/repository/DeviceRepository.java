package com.demo.statisticsapi.repository;

import com.demo.statisticsapi.model.DeviceRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository
        extends JpaRepository<DeviceRegistration, Long> {

    long countByDeviceType(String deviceType);
}
