package br.com.iteris.itc.minishop.dataprovider.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String type;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private Date birthDate;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, updatable = true)
    private ZonedDateTime updatedAt;
    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private CustomerEntity customerEntity;

    public UserEntity(String firstName, String lastName, String type, String email, String password, Date birthDate, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserEntity(UUID id, String firstName, String lastName, String type, String email, String password, Date birthDate, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
