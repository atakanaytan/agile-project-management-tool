package io.projectmanagementplatform.pmt.services;

import io.projectmanagementplatform.pmt.Exceptions.UsernameAlreadyExistException;
import io.projectmanagementplatform.pmt.domain.User;
import io.projectmanagementplatform.pmt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (User newUser){

        try{
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

            //Username has to be unique (exception)
            newUser.setUsername(newUser.getUsername());

            // Make sure that password and confirmPassword match
            // We don't persist or show the confirmPassword
            return userRepository.save(newUser);
        }catch (Exception e){
            throw new UsernameAlreadyExistException("Username '"+newUser.getUsername()+"' already exist");
        }


    }



}