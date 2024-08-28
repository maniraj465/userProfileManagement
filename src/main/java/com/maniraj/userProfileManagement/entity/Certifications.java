package com.maniraj.userProfileManagement.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certifications {
    @Column(name = "skills")
    private String name;
    private String link;
}
