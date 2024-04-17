package com.rony.creditinfix.services;


import com.rony.creditinfix.entity.auth.User;
import com.rony.creditinfix.repository.auth.UserRepository;
import com.rony.creditinfix.services.auth.userDetails.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Enter login method::loadUserByUsername():: class :: JwtUserDetailsService");
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return UserDetailsImpl.build(user.get());
    }


}
