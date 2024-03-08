package br.com.iteris.itc.minishop.dataprovider.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private double amount;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderItemEntity> orderItems;

    public OrderEntity(UUID id, double amount, ZonedDateTime createdAt) {
        this.id = id;
        this.amount = amount;
        this.createdAt = createdAt;
    }
}
