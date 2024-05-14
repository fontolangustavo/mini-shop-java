package br.com.iteris.itc.minishop.dataprovider.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cpf;
    private String phone;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public CustomerEntity(UUID id, String cpf, String phone) {
        this.id = id;
        this.cpf = cpf;
        this.phone = phone;
    }
}
