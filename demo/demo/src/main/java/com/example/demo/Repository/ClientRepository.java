package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

