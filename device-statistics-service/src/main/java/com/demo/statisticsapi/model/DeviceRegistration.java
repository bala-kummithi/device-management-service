package com.demo.statisticsapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "device_registrations",
        indexes = @Index(name="idx_device_type", columnList="deviceType"))
@Getter
@Setter
@NoArgsConstructor
public class DeviceRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userKey;

    @Column(nullable = false)
    private String deviceType;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
