package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private String userName;
    private String studentEmail;
    private String password;

    private String name;
    private String dob;
    private String sex;
    private String email;
    private String tpNumber;
    private String address;
    private String nic;
    private String school;
    private String department;
    private String course;
}
