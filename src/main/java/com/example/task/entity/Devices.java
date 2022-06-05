
package com.example.task.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "DEVICES_TEMPERATURE_AUDIT")
public class Devices extends Identity {
    @Column(name = "DEV_ID")
    private String deviceId;

    @Column(name = "LAST_TEMPERATURE")
    private Integer lastTemperature;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_AT", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    public Devices(String deviceId, Integer lastTemperature) {
        this.deviceId = deviceId;
        this.lastTemperature = lastTemperature;
        this.updatedAt = new Date();
    }
}
