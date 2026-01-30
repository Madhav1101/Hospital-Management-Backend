package com.ex.hospitalManagement.service;

import com.ex.hospitalManagement.dto.PatientResponseDto;
import com.ex.hospitalManagement.entity.Patient;
import com.ex.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    private final ModelMapper modelMapper;

//    @Transactional
//    public Patient getPatientById(Long id) {
//        Patient p1 = patientRepository.findById(id).orElseThrow();
//        Patient p2 = patientRepository.findById(id).orElseThrow();
//        System.out.println(p1 == p2);
//        p1.setName("john");
//        return p1;
//    }

    public PatientResponseDto getPatientById(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient Not " +
                "Found with id: " + patientId));
        return modelMapper.map(patient, PatientResponseDto.class);
    }

    public List<PatientResponseDto> getAllPatients(Integer pageNumber, Integer pageSize) {
        return patientRepository.findAllPatients(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDto.class))
                .collect(Collectors.toList());
    }
}