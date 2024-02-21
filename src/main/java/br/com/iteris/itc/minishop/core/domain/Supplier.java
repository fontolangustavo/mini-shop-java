package br.com.iteris.itc.minishop.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Supplier {
    private UUID id;
    private String name;
    private String cnpj;
    private String city;
    private String uf;
    private String phone;
    private String email;
    private String contact;

    public Supplier() {
    }

    public Supplier(String name, String cnpj, String city, String uf, String phone, String email, String contact) {
        this.name = name;
        this.cnpj = cnpj;
        this.city = city;
        this.uf = uf;
        this.phone = phone;
        this.email = email;
        this.contact = contact;
    }

    public Supplier(UUID id, String name, String cnpj, String city, String uf, String phone, String email, String contact) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.city = city;
        this.uf = uf;
        this.phone = phone;
        this.email = email;
        this.contact = contact;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", city='" + city + '\'' +
                ", uf='" + uf + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
