
package com.example.task.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "DEVICES_READINGS")
public class DevicesReadings extends Identity {
    @Column(name = "READING")
    private Integer readings;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @JoinColumn(name = "DEVICE_ID", referencedColumnName = "uuid")
    @ManyToOne
    private Devices device;

    public DevicesReadings(Devices selectedDevice) {
        this.device = selectedDevice;
        this.readings = selectedDevice.getLastTemperature();
        this.createdAt = new Date();
    }
}
