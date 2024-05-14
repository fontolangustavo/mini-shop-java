package br.com.iteris.itc.minishop.core.domain;

import java.util.UUID;

public class Customer {
    private UUID id;
    private String cpf;
    private String phone;
    private User user;

    public Customer() {
    }

    public Customer(String cpf, String phone) {
        this.cpf = cpf;
        this.phone = phone;
    }

    public Customer(String cpf, String phone, User user) {
        this.cpf = cpf;
        this.phone = phone;
        this.user = user;
    }

    public Customer(UUID id, String cpf, String phone) {
        this.id = id;
        this.cpf = cpf;
        this.phone = phone;
    }

    public Customer(UUID id, String cpf, String phone, User user) {
        this.id = id;
        this.cpf = cpf;
        this.phone = phone;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) { this.id = id;}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone + '\'' +
                ", user=" + user +
                '}';
    }
}
