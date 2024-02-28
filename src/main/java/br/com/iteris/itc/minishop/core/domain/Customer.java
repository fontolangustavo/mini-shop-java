package br.com.iteris.itc.minishop.core.domain;

import java.util.UUID;

public class Customer {
    private UUID id;
    private String firstName;
    private String lastName;
    private String cpf;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String cpf, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.phone = phone;
        this.email = email;
    }

    public Customer(UUID id, String firstName, String lastName, String cpf, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.phone = phone;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName (){
        return firstName + " " +  lastName;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
