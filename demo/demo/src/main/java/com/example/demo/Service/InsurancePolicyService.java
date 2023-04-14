package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Repository.InsurancePolicyRepository;
import com.example.demo.domain.InsurancePolicy;

@Service
public class InsurancePolicyService {
    
    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    public List<InsurancePolicy> getAllPolicies() {
        return insurancePolicyRepository.findAll();
    }

    public InsurancePolicy getPolicyById(Long id) {
        return insurancePolicyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Policy not found with id " + id));
    }

    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        return insurancePolicyRepository.save(policy);
    }

    public InsurancePolicy updatePolicy(Long id, InsurancePolicy policyDetails) {
        InsurancePolicy policy = insurancePolicyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Policy not found with id " + id));
        
        policy.setPolicyNumber(policyDetails.getPolicyNumber());
        policy.setType(policyDetails.getType());
        policy.setCoverageAmount(policyDetails.getCoverageAmount());
        policy.setPremium(policyDetails.getPremium());
        policy.setStartDate(policyDetails.getStartDate());
        policy.setEndDate(policyDetails.getEndDate());
        
        return insurancePolicyRepository.save(policy);
    }

    public void deletePolicy(Long id) {
        InsurancePolicy policy = insurancePolicyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Policy not found with id " + id));

        insurancePolicyRepository.delete(policy);
    }
}

