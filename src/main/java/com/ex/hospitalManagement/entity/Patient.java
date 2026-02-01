package com.ex.hospitalManagement.entity;

import com.ex.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
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

    @OneToOne
    @MapsId
    private User user;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = {CascadeType.ALL} , orphanRemoval = true)
    @JoinColumn(name= "patient_insurance_id") //owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient" , cascade = {CascadeType.REMOVE} , orphanRemoval = true , fetch = FetchType.EAGER)
    private List<Appointment> appointments = new ArrayList<>();
}