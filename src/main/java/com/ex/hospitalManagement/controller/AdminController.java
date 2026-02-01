package com.ex.hospitalManagement.controller;


import com.ex.hospitalManagement.dto.DoctorResponseDto;
import com.ex.hospitalManagement.dto.PatientResponseDto;
import com.ex.hospitalManagement.dto.onBoardDoctorRequestDto;
import com.ex.hospitalManagement.service.DoctorService;
import com.ex.hospitalManagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final PatientService patientService;
    private final DoctorService doctorService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDto>> getAllPatients(
            @RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(patientService.getAllPatients(pageNumber, pageSize));
    }

    @PostMapping("/onBoardNewDr")
    public ResponseEntity<DoctorResponseDto> orBoardNewDoctor(@RequestBody onBoardDoctorRequestDto onBoardDrReqDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.onBoardNewDoctor(onBoardDrReqDto));
    }
}
