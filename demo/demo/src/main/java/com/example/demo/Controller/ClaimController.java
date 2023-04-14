package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Repository.ClaimRepository;
import com.example.demo.Repository.InsurancePolicyRepository;
import com.example.demo.domain.Claim;
import com.example.demo.domain.InsurancePolicy;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    
    @Autowired
    private ClaimRepository claimRepository;
    
    @Autowired
    private InsurancePolicyRepository policyRepository;

    // GET all claims
    @GetMapping
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    // GET a claim by ID
    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable(value = "id") Long claimId)
            throws ResourceNotFoundException {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found for this id :: " + claimId));
        return ResponseEntity.ok().body(claim);
    }

    // POST a new claim
    @PostMapping
    public Claim createClaim(@Valid @RequestBody Claim claim) throws ResourceNotFoundException {
        InsurancePolicy policy = policyRepository.findById(claim.getPolicy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found for this id :: " + claim.getPolicy().getId()));
        claim.setPolicy(policy);
        return claimRepository.save(claim);
    }

    // PUT update an existing claim
    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable(value = "id") Long claimId,
                                              @Valid @RequestBody Claim claimDetails) throws ResourceNotFoundException {
        Claim claim = claimRepository.findById(claimId)
        		.orElseThrow(() -> new ResourceNotFoundException("Claim not found for this id :: " + claimId));

        InsurancePolicy policy = policyRepository.findById(claimDetails.getPolicy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found for this id :: " + claimDetails.getPolicy().getId()));

        claim.setClaimNumber(claimDetails.getClaimNumber());
        claim.setDescription(claimDetails.getDescription());
        claim.setClaimDate(claimDetails.getClaimDate());
        claim.setPolicy(policy);
        claim.setStatus(claimDetails.getStatus());

        final Claim updatedClaim = claimRepository.save(claim);
        return ResponseEntity.ok(updatedClaim);
    }

    // DELETE a claim
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteClaim(@PathVariable(value = "id") Long claimId)
            throws ResourceNotFoundException {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found for this id :: " + claimId));

        claimRepository.delete(claim);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
