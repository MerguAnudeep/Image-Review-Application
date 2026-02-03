package com.example.demo;

import com.example.demo.registerLogin.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    UserRepo userrepo;

//    public String  addDetails(UserDetails userDetails){
//
//        if(userrepo.existsByEmail(userDetails.getEmail())){
//            return "Already Existed";
//        }
//        userrepo.save(userDetails);
//        return "Added successfully";
//    }
//    public String userLogin(Login login) {
//
//        if (!userrepo.existsByEmail(login.getEmail())) {
//            return "Email not found";
//        }
//
//        UserDetails user = userrepo.findByEmail(login.getEmail()).get();
//
//        if (login.getPassword().equals(user.getPassword())) {
//            return login.getEmail()+"";
//        }
//
//        return "Invalid password";
//    }


//    public String userLogin(Login login){
//        UserDetails user = repo.findByEmail(login.getEmail()).get();
//        if(repo.existsByEmail(login.getEmail())){
//            if(login.getPassword().equals(user.getPassword())){
//                 return "Login Successfully and Welcome";
//            }
//            else{
//                return "Invalid Password";
//            }
//        }
//        return "U does not have account. Create Account";
//    }
}
