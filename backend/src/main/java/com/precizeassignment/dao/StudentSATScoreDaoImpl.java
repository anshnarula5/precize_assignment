package com.precizeassignment.dao;

import com.precizeassignment.entity.StudentSATScore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Repository
public class StudentSATScoreDaoImpl implements StudentSATScoreDao{
    private final EntityManager entityManager;
    @Autowired
    public StudentSATScoreDaoImpl(final EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public void save(final StudentSATScore studentSATScore) {
        try {
            System.out.println("Saving record into db : ");
            entityManager.persist(studentSATScore);
            System.out.println("Application saved to db - dao : " + studentSATScore.studentName);
        } catch (final Exception e){
            System.out.println("Exception in saving recordf for: " + studentSATScore.studentName);
            System.out.println(Arrays.toString(e.getStackTrace()));
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<StudentSATScore> getAllScores() {
        TypedQuery<StudentSATScore> query = entityManager.createQuery("FROM StudentSATScore", StudentSATScore.class);
        return query.getResultList();
    }

    @Override
    public Integer getStudentRank(String studentName) {
        try {
            TypedQuery<Double> query = entityManager.createQuery(
                    "SELECT s.satScore FROM StudentSATScore s WHERE s.studentName = :studentName", Double.class);
            query.setParameter("studentName", studentName);
            Double studentScore = query.getSingleResult();

            TypedQuery<Long> countQuery = entityManager.createQuery(
                    "SELECT COUNT(s) FROM StudentSATScore s WHERE s.satScore > :studentScore", Long.class);
            countQuery.setParameter("studentScore", studentScore);
            Long count = countQuery.getSingleResult();

            return Math.toIntExact(count + 1);
        } catch (Exception e) {
            System.out.println("Exception in getting rank for: " + studentName);
            System.out.println(Arrays.toString(e.getStackTrace()));
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateScoreByName(final String studentName, final StudentSATScore updatedStudent) {
        try {
            StudentSATScore existingStudent = entityManager.find(StudentSATScore.class, studentName);
            if (existingStudent != null) {
                // Update the fields of the existingStudent object based on the updatedStudent object
                existingStudent.address = updatedStudent.getAddress();
                existingStudent.city = updatedStudent.getCity();
                existingStudent.country = updatedStudent.getCountry();
                existingStudent.pincode = updatedStudent.getPincode();
                existingStudent.satScore = updatedStudent.getSatScore();

                entityManager.merge(existingStudent);
                System.out.println("Updated SAT score for " + studentName);
            } else {
                System.out.println("No student found with the name: " + studentName);
            }
        } catch (Exception e) {
            System.out.println("Exception in updating score for: " + studentName);
            System.out.println(Arrays.toString(e.getStackTrace()));
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteScore(final String studentName) {
        try {
            System.out.println("Deleting record from db : " + studentName);
            final StudentSATScore studentSATScore = entityManager.find(StudentSATScore.class, studentName);
            if (studentSATScore != null) {
                entityManager.remove(studentSATScore);
            } else {
                throw new RuntimeException("Student not found with name: " + studentName);
            }
            System.out.println("Record deleted from db : " + studentName);
        } catch (final Exception e) {
            System.out.println("Exception in deleting record for: " + studentName);
            throw new RuntimeException(e);
        }
    }
}
