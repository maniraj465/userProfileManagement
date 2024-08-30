package com.maniraj.userProfileManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "working_experiences")
public class WorkingExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "working_experience_id")
    private Long workingExperienceId;
    private String employer ;
    private String jobTitle;
    private String startDate;
    private String endDate;
    @Column(name = "responsibilities", length = 5000)
    private List<String> responsibilities;
}
