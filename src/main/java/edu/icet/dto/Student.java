package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private String dob;
    private String sex;
    private String email;
    private String address;
    private String nic;
    private String school;
    private String department;
    private String course;
    private String tpNumber;
}
