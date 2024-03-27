package br.com.iteris.itc.minishop.dataprovider.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    private String image;
    private boolean isDiscontinued;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;

    public ProductEntity(UUID id, String name, BigDecimal price, boolean isDiscontinued) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isDiscontinued = isDiscontinued;
    }
}
