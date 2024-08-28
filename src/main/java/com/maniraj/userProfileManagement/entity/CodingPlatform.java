package com.maniraj.userProfileManagement.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coding_platforms")
public class CodingPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long platformId;
    private String platformName;
    @Column(name = "platform_link", length = 3000)
    private String platformLink;
}
