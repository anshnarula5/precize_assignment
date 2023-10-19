package com.precizeassignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "student_sat_score")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Setter
@Getter
public class StudentSATScore {
    @Id
    @Column(name = "student_name", unique = true)
    @NotNull
    @NotBlank
    public final String studentName;

    @Column(name = "address")
    @NotNull
    @NotBlank
    public String address;

    @Column(name = "city")
    @NotNull
    @NotBlank
    public String city;

    @Column(name = "country")
    @NotNull
    @NotBlank
    public String country;

    @Column(name = "pincode")
    @NotNull
    @NotBlank
    public String pincode;

    @Column(name = "sat_score")
    @NotNull
    public Double satScore;

    @Column(name = "passed")
    public Boolean passed;

}
