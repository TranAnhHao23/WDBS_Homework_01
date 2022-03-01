package cg.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "human")
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "check not null")
//    @Pattern(regexp = "[a-zA-Z]", message = "check not number")
    private String name;

    @Pattern(regexp = "([0-9]{10,11})", message = "check number wrong")
    private String phoneNumber;

    private String address;

    @Pattern(regexp = "([0-9]{9})", message = "check number wrong")
    private String identityNumber;

    public Human() {
    }

    public Human(String name, String phoneNumber, String address, String identityNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.identityNumber = identityNumber;
    }

    public Human(Long id, String name, String phoneNumber, String address, String identityNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.identityNumber = identityNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
}
