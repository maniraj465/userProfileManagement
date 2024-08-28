package com.maniraj.userProfileManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor@Entity
@Table(name = "profile_pictures")
public class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_picture_id")
    private Long profilePictureId;
    @Lob
    @Column(name = "profile_image_data", length = 1000)
    private byte[] imageData;

}
