package com.gcorp.data.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class PersonDTO implements Serializable {

    private static final long serialVersion = 1L;

    private Long id;

    @Column(name = "first_name", nullable = false, length = 40)
    private String name;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastname;

    @Column(nullable = false, length = 100)
    private String address;

    public PersonDTO() {}

    public PersonDTO(Long id, String name, String lastname, String address) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        com.gcorp.data.dto.PersonDTO person = (com.gcorp.data.dto.PersonDTO) o;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getName(), person.getName()) && Objects.equals(getLastname(), person.getLastname()) && Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastname(), getAddress());
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

