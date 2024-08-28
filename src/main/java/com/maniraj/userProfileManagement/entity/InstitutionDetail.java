package com.maniraj.userProfileManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "institution_details")
public class InstitutionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "institution_detail_id")
    private Long institutionDetailId;
    private String institutionName;
    private String educationLevel;
    private String major;
    private String startDate;
    private String graduationDate;
    @Column(name = "achievements", length = 5000)
    private String[] achievements;
}
