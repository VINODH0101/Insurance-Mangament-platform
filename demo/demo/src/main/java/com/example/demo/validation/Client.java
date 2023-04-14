package com.example.demo.validation;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.lang.String;
import java.util.Date;

import org.hibernate.annotations.Type;
import org.hibernate.usertype.UserType;

@Entity
@Table(name = "clients")
public class Client<ContactInfo> {

    

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Date of birth is required")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NotBlank(message = "Address is required")
    private String address;

    
    @Valid
    @NotNull(message = "Contact information is required")
    
    @OneToMany(cascade = CascadeType.ALL)
    
    @JoinColumn(name = "contact_info_id", referencedColumnName = "id")
    private ContactInfo contactInfo;

    public Client() {}

    public Client(String name, Date dateOfBirth, String address, ContactInfo contactInfo) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.contactInfo = contactInfo;
    }

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ContactInfo getcontactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
