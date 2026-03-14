package com.luisdev.serviceorder.repository;

import com.luisdev.serviceorder.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Client, Long> = Spring Data JPA gera automaticamente save(), findAll(), FindById(), DeleteById(), count(), existsById()
public interface ClientRepository extends JpaRepository<Client, Long> {

}
