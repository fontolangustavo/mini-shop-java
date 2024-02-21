package br.com.iteris.itc.minishop.dataprovider.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class ProductEntity {
    @Id
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;

    private boolean isDiscontinued;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;
}
