package com.example.nguyenthithungan.mentalhealthngan;

public class UserInformation {
    private String email;
    private String name;
    private String phone;
    public UserInformation() {

    }

    public UserInformation(String email, String name,String phone) {
        this.email = email;
        this.name = name;
        this.phone= phone;

    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
}
