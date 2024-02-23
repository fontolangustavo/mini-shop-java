package br.com.iteris.itc.minishop.dataprovider.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suppliers")
public class SupplierEntity {
    @Id
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String cnpj;
    @NotNull
    private String city;
    @NotNull
    private String uf;
    private String phone;
    @NotNull
    private String email;
    private String contact;
    @OneToMany
    @JoinColumn(name = "supplier_id")
    private List<ProductEntity> products;
}
