package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}