package com.example.demo.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ClaimValidation {
    
    private Long id;
    
    @NotBlank(message = "Claim number is mandatory")
    private String claimNumber;
    
    @NotBlank(message = "Description is mandatory")
    private String description;
    
    @NotNull(message = "Claim date is mandatory")
    private LocalDate claimDate;
    
    @NotBlank(message = "Claim status is mandatory")
    private String claimStatus;
    
    private InsurancePolicy insurancePolicy;
    
    // Constructor
    public ClaimValidation(Long id, String claimNumber, String description, LocalDate claimDate, String claimStatus, InsurancePolicy insurancePolicy) {
        this.id = id;
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
        this.insurancePolicy = insurancePolicy;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }
}

