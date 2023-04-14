package com.example.demo.domain;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(nullable= false)
	private String name;
	@Column(nullable= false)
    private String dateOfBirth;
	@Column(nullable= false)
	private String address;
	@Column(nullable= false)
	private String contactInfo;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL) 
  private List<InsurancePolicy> policies;
    public Client(String name, String dateOfBirth,String address,String contactInfo) {
    	this.name=name;
    	this.dateOfBirth= dateOfBirth;
    	this.address=address;
    	this.contactInfo=contactInfo;
    }
   public Long getId() {
	   return id;
   }
    
   public void setId(Long id) {
	   this.id=id;
   }
   public String getName() {
	   return name;
   }
    public void setName(String name) {
    	this.name=name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public List<InsurancePolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<InsurancePolicy> policies) {
        this.policies = policies;
    }
    
    
  }
