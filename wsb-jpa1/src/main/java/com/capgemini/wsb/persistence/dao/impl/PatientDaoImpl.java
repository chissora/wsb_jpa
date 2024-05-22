package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.lastName LIKE :lastName", PatientEntity.class)
                .setParameter("lastName", "%" + lastName + "%")
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByVisitsCountGreaterThan(Long visitsCount) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p " +
                                "JOIN p.visits v " +
                                "GROUP BY p.id, p.firstName, p.lastName, p.telephoneNumber, p.email, p.patientNumber, p.dateOfBirth, p.age " +
                                "HAVING COUNT(v.id) > :visitsCount", PatientEntity.class)
                .setParameter("visitsCount", visitsCount)
                .getResultList();
    }




    @Override
    public List<VisitEntity> findVisitsByPatientId(Long id) {
        return entityManager.createQuery("SELECT v FROM VisitEntity v WHERE v.patient.id = :id", VisitEntity.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByAgeGreaterThan(int age) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.age > :age", PatientEntity.class)
                .setParameter("age", age)
                .getResultList();
    }
}
