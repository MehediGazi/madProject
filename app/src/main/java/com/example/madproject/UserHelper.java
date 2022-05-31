package com.example.madproject;

public class UserHelper {

    String name, phone, dob, pass;

    public UserHelper() {
    }

    public UserHelper(String name, String phone, String dob, String pass) {
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        //this.gender = gender;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    //public String getGender() {
    //    return gender;
    //}

    //public void setGender(String gender) {
    //    this.gender = gender;
    //}

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
