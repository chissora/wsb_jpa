package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testFindPatientsByLastName() {
        // given
        String lastName = "Nowak";

        // when
        List<PatientEntity> patients = patientDao.findByLastName(lastName);

        // then
        assertThat(patients).hasSize(2); // Zakładając, że masz 2 pacjentów z nazwiskiem Nowak
    }

    @Test
    @Transactional
    public void testFindPatientsWithMoreThanXVisits() {
        // given
        long visitCount = 1;

        // when
        List<PatientEntity> patients = patientDao.findByVisitsCountGreaterThan(visitCount);

        // then
        assertThat(patients).isNotEmpty();
        // Ensuring visits are loaded
        patients.forEach(patient -> {
            PatientEntity reloadedPatient = entityManager.find(PatientEntity.class, patient.getId());
            assertThat(reloadedPatient.getVisits().size()).isGreaterThan((int) visitCount);
        });
    }

    @Test
    public void testFindPatientsByAgeGreaterThan() {
        // given
        int age = 24;

        // when
        List<PatientEntity> patients = patientDao.findByAgeGreaterThan(age);

        // then
        assertThat(patients).isNotEmpty();
        assertThat(patients).allMatch(patient -> patient.getAge() > age);
    }

    @Test
    public void testFindPatientVisits() {
        // given
        Long patientId = 1L;

        // when
        List<VisitEntity> visits = patientDao.findVisitsByPatientId(patientId);

        // then
        assertThat(visits).isNotEmpty();
        assertThat(visits).allMatch(visit -> visit.getPatient().getId().equals(patientId));
    }
}
