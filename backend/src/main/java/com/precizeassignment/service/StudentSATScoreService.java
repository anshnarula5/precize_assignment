package com.precizeassignment.service;

import com.precizeassignment.dao.StudentSATScoreDao;
import com.precizeassignment.entity.StudentSATScore;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSATScoreService {
    private final StudentSATScoreDao studentSATScoreDao;
    @Autowired
    public StudentSATScoreService(final StudentSATScoreDao studentSATScoreDao){
        this.studentSATScoreDao = studentSATScoreDao;
    }

    @Transactional
    public void addNewSATScore(final StudentSATScore studentSATScore){
        try {
            System.out.println("Service : Adding new SAT Score");
            final Double score = studentSATScore.getSatScore();
            studentSATScore.passed = score >= 30.00;
            studentSATScoreDao.save(studentSATScore);
            System.out.println("Service : Successfully added record");
        } catch (final RuntimeException e){
            System.out.println("Service : Exception in adding record : " + studentSATScore.studentName);
            throw new RuntimeException(e);
        }
    }
    public List<StudentSATScore> getAllSATScores(){
        return studentSATScoreDao.getAllScores();
    }

    public Integer getStudentRank(String studentName) {
        try {
            System.out.println("Service : Getting rank for " + studentName);
            return studentSATScoreDao.getStudentRank(studentName);
        } catch (final RuntimeException e){
            System.out.println("Service : Exception in getting rank for: " + studentName);
            throw new RuntimeException(e);
        }
    }
    @Transactional
    public void updateScoreByName(final String studentName, final StudentSATScore updatedStudent) {
        try {
            System.out.println("Service : Updating SAT score for " + studentName);
            final Double score = updatedStudent.getSatScore();
            updatedStudent.passed = score >= 30.00;
            studentSATScoreDao.updateScoreByName(studentName, updatedStudent);
        } catch (final RuntimeException e) {
            System.out.println("Service : Exception in updating score for: " + studentName);
            throw new RuntimeException(e);
        }
    }
    @Transactional
    public void deleteStudent(String studentName) {
        try {
            System.out.println("Service : Deleting student with name " + studentName);
            studentSATScoreDao.deleteScore(studentName);
            System.out.println("Service : Deleted student with name " + studentName);
        } catch (final RuntimeException e) {
            System.out.println("Service : Exception in deleting student with name " + studentName);
            throw new RuntimeException(e);
        }
    }
}
