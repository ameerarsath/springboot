package com.first.crud.DTO;

public class SaveDTO {

    private String name;
    private String mobile;
    private String email;

    public SaveDTO(String name, String mobile, String email) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    public SaveDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SaveDTO [name=" + name + ", mobile=" + mobile + ", email=" + email + "]";
    }
}
