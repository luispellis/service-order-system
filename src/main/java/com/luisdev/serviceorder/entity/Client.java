package com.luisdev.serviceorder.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// @Entity = Indica ao Spring + JPA que essa classe vira uma tabela no BD
// @Table(name = "clients" = Define o nome da tabela
@Entity
@Table(name = "clients")
public class Client {

    // @Id Chave Primária
    // @GeneratedValue = Define geração automática do ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(nullable = false) = Campo obrigatório no banco
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
