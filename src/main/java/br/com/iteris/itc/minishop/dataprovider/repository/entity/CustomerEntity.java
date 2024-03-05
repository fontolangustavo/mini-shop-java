package br.com.iteris.itc.minishop.dataprovider.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private UUID id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String cpf;
    @NotNull
    private String email;
    private String phone;
}
