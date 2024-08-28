package com.maniraj.userProfileManagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private UserRoles role;
    @JsonFormat(pattern = "yyy-MM-dd", shape = Shape.STRING)
    @Column(name = "date_of_birth")
    private String dob;
    @Column(name = "create_date")
    private String createdDate;
    @Column(name = "updated_date")
    private String updatedDate;
    @Column(name = "occupation")
    private Occupation occupation;
    @Column(name = "skills")
    private List<String> skills;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private List<InstitutionDetail> institutionDetail = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private List<WorkingExperience> workingExperience;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private List<CodingPlatform> codingPlatform;
    @Lob
    @Column(name = "profile_picture", length = 5000)
    private byte[] profilePicture; // Image will be converted to Base64 String

//    @OneToOne
//    private ProfilePicture profilePicture;
//    @OneToMany
//    private Project projects;
}
