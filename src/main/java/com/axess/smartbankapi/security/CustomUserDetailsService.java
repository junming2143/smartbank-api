package com.axess.smartbankapi.security;

import com.axess.smartbankapi.model.CCUser;
import com.axess.smartbankapi.repository.CCUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/***
 * In this class, we tell Spring Security how to look up the user information,
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CCUserRepository userRepo;

    /**
     *Spring Security will invoke the loadUserByUsername() method to authenticate the user, and if successful,
     * a new object of type CustomUserDetails object is created to represent the authenticated user.
     */
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        CCUser user = userRepo.findByUserId(userId);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
