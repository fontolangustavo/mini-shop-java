package br.com.iteris.itc.minishop.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
  private UUID id;
  private String name;
  private BigDecimal price;
  private boolean isDiscontinued;
  private Supplier supplier;

  public Product() {
  }

  public Product(String name, BigDecimal price) {
    this.name = name;
    this.price = price;
  }

  public Product(UUID id, String name, BigDecimal price, boolean isDiscontinued) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.isDiscontinued = isDiscontinued;
  }

  public Product(UUID id, String name, BigDecimal price, boolean isDiscontinued, Supplier supplier) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.isDiscontinued = isDiscontinued;
    this.supplier = supplier;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public boolean isDiscontinued() {
    return isDiscontinued;
  }

  public void setDiscontinued(boolean discontinued) {
    isDiscontinued = discontinued;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  @Override
  public String toString() {
    return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", isDiscontinued=" + isDiscontinued +
            ", supplier=" + supplier +
            '}';
  }
}
