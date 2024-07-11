package dev.example.spring;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", length = 10, columnDefinition = "serial")
    private int id;

    @Column(name = "customer_name", nullable = false , length = 20)
    private String name;

    @Column(name = "customer_mail", nullable = false , unique = true)
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate ondate;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private Gender gender;
    public enum Gender{
        MALE,
        FEMALE
    }

    public Customer() {
    }

    public Customer(int id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getOndate() {
        return ondate;
    }

    public void setOndate(LocalDate ondate) {
        this.ondate = ondate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "dev.example.spring.Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", ondate=" + ondate +
                ", gender=" + gender +
                '}';
    }
}