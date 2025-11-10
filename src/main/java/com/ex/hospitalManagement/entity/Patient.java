package com.ex.hospitalManagement.entity;

import com.ex.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        uniqueConstraints = {
//                @UniqueConstraint(name = "unique_patient_email" , columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthdate" , columnNames = {"name", "birthdate"})
        },
        indexes = {
                @Index(name = "idx_patient_birth_date", columnList = "birthdate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private LocalDate birthdate;
    @Column(unique = true , nullable = false)
    private String email;
    private String gender;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodgroup;

    public Patient(long id, String name, LocalDate birthdate, String email, String gender , String bloodgroup) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.gender = gender;
        this.bloodgroup = BloodGroupType.valueOf(bloodgroup.toUpperCase());
    }

    public Patient() {
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", createdAt=" + createdAt +
                ", bloodgroup='" + bloodgroup + '\'' +
                '}';
    }

    public BloodGroupType getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(BloodGroupType bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}