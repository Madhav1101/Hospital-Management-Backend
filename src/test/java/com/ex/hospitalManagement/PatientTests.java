package com.ex.hospitalManagement;

import com.ex.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.ex.hospitalManagement.entity.Patient;
import com.ex.hospitalManagement.entity.type.BloodGroupType;
import com.ex.hospitalManagement.repository.PatientRepository;
import com.ex.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    private  PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods() {
//        Patient patient = patientRepository.findByName("Diya Patel");
//        List<Patient> patientList = patientRepository.findByBirthdateOrEmail(LocalDate.of(1993,7,11), "diya.patel@example.com");

//        List<Patient> patientList = patientRepository.findByNameContainingOrderByNameDesc("Di");
//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1990,3,15));
        Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(0,3, Sort.by("name")));
        for(Patient patient: patientList) {
        System.out.println(patient);
        }
//
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] objects: bloodGroupList) {
//            System.out.println(objects[0] +" "+objects[1]);
//        }

//          List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//          for(BloodGroupCountResponseEntity bloodGroupCountResponse : bloodGroupList) {
//              System.out.println(bloodGroupCountResponse);
//          }

//        int rowUpdated = patientRepository.updateNameWithId("Arav Sharma" , 11L);
//        System.out.println(rowUpdated);
    }
}
