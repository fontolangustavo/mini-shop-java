package br.com.iteris.itc.minishop.core.domain;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String type;
    private String password;
    private String email;
    private Date birthDate;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Customer customer;

    public User() {
    }

    public User(String firstName, String lastName, String password, String email, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
    }

    public User(String firstName, String lastName, String type, String password, String email, Date birthDate, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(UUID id, String firstName, String lastName, String type, String password, String email, Date birthDate, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(UUID id, String firstName, String lastName, String type, String password, String email, Date birthDate, ZonedDateTime createdAt, ZonedDateTime updatedAt, Customer customer) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.customer = customer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName () {
        return firstName + " " + lastName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public String getFormattedEmail() {
        if( type != null )
        {
            // Remove "type_" from begin
            email = email.replaceAll("^" + type + "_", "");
        }

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type='" + type + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", customer=" + customer +
                '}';
    }

    public boolean validatePassword(String password, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, this.password);
    }
}
