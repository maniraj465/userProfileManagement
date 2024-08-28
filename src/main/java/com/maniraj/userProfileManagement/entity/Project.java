package com.maniraj.userProfileManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private String name;
    private List<byte[]> screenshots;
}
