package br.com.iteris.itc.minishop.core.domain;

import java.time.ZonedDateTime;
import java.util.UUID;

public class PasswordResetToken {
    private UUID id;
    private String token;
    private ZonedDateTime expiryAt;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private User user;

    public PasswordResetToken() {
    }

    public PasswordResetToken(String token, ZonedDateTime expiryAt, User user) {
        this.token = token;
        this.expiryAt = expiryAt;
        this.user = user;
    }

    public PasswordResetToken(UUID id, String token, ZonedDateTime expiryAt, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.id = id;
        this.token = token;
        this.expiryAt = expiryAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public PasswordResetToken(UUID id, String token, ZonedDateTime expiryAt, ZonedDateTime createdAt, ZonedDateTime updatedAt, User user) {
        this.id = id;
        this.token = token;
        this.expiryAt = expiryAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ZonedDateTime getExpiryAt() {
        return expiryAt;
    }

    public void setExpiryAt(ZonedDateTime expiryAt) {
        this.expiryAt = expiryAt;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PasswordResetToken{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", expiryAt=" + expiryAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", user=" + user +
                '}';
    }

    public boolean isTokenExpired() {
        return this.expiryAt.isAfter(ZonedDateTime.now());
    }
}
