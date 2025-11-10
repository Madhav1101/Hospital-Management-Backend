package com.ex.hospitalManagement.service;

import com.ex.hospitalManagement.entity.Patient;
import com.ex.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    public Patient getPatientById(Long id) {
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();
        System.out.println(p1 == p2);
        p1.setName("john");
        return p1;
    }
}
