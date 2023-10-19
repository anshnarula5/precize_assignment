package com.precizeassignment.dao;

import com.precizeassignment.entity.StudentSATScore;

import java.util.List;

public interface StudentSATScoreDao {
    void save(final StudentSATScore studentSATScore);
    List<StudentSATScore> getAllScores();
    Integer getStudentRank(final String studentName);
    void updateScoreByName(final String studentName, final StudentSATScore studentSATScore);
    void deleteScore(final String studentName);
}
