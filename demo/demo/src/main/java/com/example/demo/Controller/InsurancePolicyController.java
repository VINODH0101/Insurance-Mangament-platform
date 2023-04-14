package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.InsurancePolicyService;
import com.example.demo.domain.InsurancePolicy;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    private InsurancePolicyService policyService;

    // GET all policies
    @GetMapping
    public ResponseEntity<List<InsurancePolicy>> getAllPolicies() {
        List<InsurancePolicy> policies = policyService.getAllPolicies();
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

    // GET a policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getPolicyById(@PathVariable Long id) {
        InsurancePolicy policy = policyService.getPolicyById(id);
        return new ResponseEntity<>(policy, HttpStatus.OK);
    }

    // CREATE a new policy
    @PostMapping
    public ResponseEntity<InsurancePolicy> createPolicy(@RequestBody InsurancePolicy policy) {
        InsurancePolicy newPolicy = policyService.createPolicy(policy);
        return new ResponseEntity<>(newPolicy, HttpStatus.CREATED);
    }

    // UPDATE an existing policy by ID
    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicy> updatePolicy(@PathVariable Long id, @RequestBody InsurancePolicy policy) {
        InsurancePolicy updatedPolicy = policyService.updatePolicy(id, policy);
        return new ResponseEntity<>(updatedPolicy, HttpStatus.OK);
    }

    // DELETE a policy by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

