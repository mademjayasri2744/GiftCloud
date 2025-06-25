package com.giftydelivery.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long giftId;
    private LocalDateTime scheduledTime;
    private String status = "PENDING";

    // Getters
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getGiftId() { return giftId; }
    public LocalDateTime getScheduledTime() { return scheduledTime; }
    public String getStatus() { return status; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setGiftId(Long giftId) { this.giftId = giftId; }
    public void setScheduledTime(LocalDateTime scheduledTime) { this.scheduledTime = scheduledTime; }
    public void setStatus(String status) { this.status = status; }
}
