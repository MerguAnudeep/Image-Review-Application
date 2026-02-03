package com.example.demo.registerLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserRepo userrepo;
    public String  addDetails(UserDetails userDetails){

        if(userrepo.existsByEmail(userDetails.getEmail())){
            return "Already Existed";
        }
        userrepo.save(userDetails);
        return "Added successfully";
    }
    public String userLogin(Login login) {

        if (!userrepo.existsByEmail(login.getEmail())) {
            return "Email not found";
        }

        UserDetails user = userrepo.findByEmail(login.getEmail()).get();

        if (login.getPassword().equals(user.getPassword())) {
            return login.getEmail()+"";
        }

        return "Invalid password";
    }
}
