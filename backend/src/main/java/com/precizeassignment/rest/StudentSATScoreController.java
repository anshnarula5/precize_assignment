package com.precizeassignment.rest;

import com.precizeassignment.dto.SuccessResponse;
import com.precizeassignment.entity.StudentSATScore;
import com.precizeassignment.utils.ControllerHelper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.precizeassignment.service.StudentSATScoreService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@Validated
@CrossOrigin
public class StudentSATScoreController {
    private final StudentSATScoreService studentSATScoreService;
    private final ControllerHelper controllerHelper;

    @Autowired
    public StudentSATScoreController(final StudentSATScoreService studentSATScoreService,
                                     final ControllerHelper controllerHelper){
        this.studentSATScoreService = studentSATScoreService;
        this.controllerHelper = controllerHelper;
    }

    @GetMapping("")
    ResponseEntity<SuccessResponse<List<StudentSATScore>>> getAllStudentSATScores(){
        try {
            System.out.println("Controller : Fetching all scores");
            final List<StudentSATScore> scores = studentSATScoreService.getAllSATScores();
            System.out.println("Controller : Success");
            return controllerHelper.buildSuccessResponse(scores);
        } catch (final Exception e){
            System.out.println("Controller : Exception in fetching all scores");
            throw new RuntimeException(e);
        }
    }

    @PostMapping("")
    ResponseEntity<SuccessResponse<StudentSATScore>> addNewSATScore(@Valid @RequestBody final StudentSATScore satScore,
                                                                          final BindingResult bindingResult){
        controllerHelper.validateInput(bindingResult);
        System.out.println("Controller : Creating a new SAT score record");
        try {
            studentSATScoreService.addNewSATScore(satScore);
            System.out.println("Controller : Added new SAT score record : " + satScore.getStudentName());
            return controllerHelper.buildSuccessResponse(satScore);
        } catch (Exception e){
            System.out.println("Controller : SAT score creation failed");
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/rank")
    ResponseEntity<SuccessResponse<Integer>> getStudentRank(@RequestBody Map<String, String> requestBody) {
        final String studentName = requestBody.get("studentName");
        try {
            System.out.println("Controller : Fetching rank for " + studentName);
            Integer rank = studentSATScoreService.getStudentRank(studentName);
            System.out.println("Controller : Successfully retrieved rank for " + studentName);
            return controllerHelper.buildSuccessResponse(rank);
        } catch (final Exception e){
            System.out.println("Controller : Exception in fetching rank for " + studentName);
            throw new RuntimeException(e);
        }
    }

    @PutMapping("")
    public ResponseEntity<SuccessResponse<StudentSATScore>> updateScoreByName(
            @Valid @RequestBody final StudentSATScore studentSATScore,
            final BindingResult bindingResult) {
        controllerHelper.validateInput(bindingResult);
        try {
            final String studentName = studentSATScore.getStudentName();
            studentSATScoreService.updateScoreByName(studentName, studentSATScore);
            return controllerHelper.buildSuccessResponse(studentSATScore);
        } catch (final Exception e){
            System.out.println("Controller : Exception in updating score");
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping("")
    public ResponseEntity<SuccessResponse<String>> deleteScoreByName(@RequestBody Map<String, String> requestBody) {
        String studentName = requestBody.get("studentName");
        try {
            System.out.println("Controller : Deleting score for " + studentName);
            studentSATScoreService.deleteStudent(studentName);
            System.out.println("Controller : Deleted score for " + studentName);
            return controllerHelper.buildSuccessResponse("Deleted score for " + studentName);
        } catch (final Exception e){
            System.out.println("Controller : Exception in deleting score");
            throw new RuntimeException(e);
        }
    }

}
