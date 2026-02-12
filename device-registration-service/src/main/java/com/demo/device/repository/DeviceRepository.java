package com.demo.device.repository;



import com.demo.device.model.DeviceRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<DeviceRegistration, Long> {
}
