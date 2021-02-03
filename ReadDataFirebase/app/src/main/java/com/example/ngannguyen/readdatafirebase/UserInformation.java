package com.example.ngannguyen.readdatafirebase;

public class UserInformation {
    private String email;
    private String name;
    private String phone;
    public UserInformation() {

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
