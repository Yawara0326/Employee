package com.yawara.employee.dto;

import jakarta.validation.constraints.Email;
import org.springframework.lang.NonNull;

public class EmployeeRequest {

    @NonNull
    private String name;

    @NonNull
    private String idNumber;

    @NonNull
    @Email
    private String email;

    private String imageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
