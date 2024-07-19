package com.culysoft.usermodule.service;

import com.culysoft.usermodule.exception.UserBusinessException;
import com.culysoft.usermodule.models.User;
import com.culysoft.usermodule.repository.UserRepository;
import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
//@AllArgsConstructor
public class UserDetailsServiceImpl
//        implements UserDetailsService
{

//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByEmail(email);
//
//        if (user.isEmpty()) throw new UsernameNotFoundException("User not found.");
//        if (!user.get().isStatus()) throw new UserBusinessException("Account disabled");
//        User userFound = user.orElseThrow(() -> new UsernameNotFoundException("Invalid email or password."));
//
//        return new com.culysoft.usermodule.models.UserDetails(userFound);
//    }

}
