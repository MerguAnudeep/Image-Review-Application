package com.example.demo.registerLogin;

import jakarta.persistence.*;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String UserName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private int Age;
    private String mobile_no;
    private String Location;

    public UserDetails() {
    }
    public UserDetails(String UserName, String Email, String password, int Age, String Mobile_no, String Location) {
        this.UserName =UserName;
        this.password=password;
        this.email =Email;
        this.Age =Age;
        this.mobile_no =Mobile_no;
        this.Location =Location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobileNo) {
        System.out.print("Setter from mo_no");
        this.mobile_no = mobileNo;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }
}
