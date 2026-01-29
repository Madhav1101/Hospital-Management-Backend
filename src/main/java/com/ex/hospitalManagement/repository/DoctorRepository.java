package com.ex.hospitalManagement.repository;

import com.ex.hospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor , Long> {
}
