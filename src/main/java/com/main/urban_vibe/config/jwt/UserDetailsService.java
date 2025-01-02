package com.main.urban_vibe.config.jwt;

import com.main.urban_vibe.daos.UserDao;
import com.main.urban_vibe.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email); // Assuming you have a method to find user by email
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // Assuming your User entity has a 'roles' property
        List<GrantedAuthority> authorities = new ArrayList<>();
        // For simplicity, let's assume your Role entity has a 'name' property. Adjust as necessary.
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }
}