package com.telusko.SpringSecEx.service;

import com.telusko.SpringSecEx.model.UserPrincipal;
import com.telusko.SpringSecEx.model.Users;
import com.telusko.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
            Users user = repo.findByUsername(username);
            if(user == null){
                System.out.println("User Not found");
                throw new UsernameNotFoundException("user not found");
            }
            return new UserPrincipal(user);
        }
}
