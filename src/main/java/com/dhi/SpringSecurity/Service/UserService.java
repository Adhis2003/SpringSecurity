package com.dhi.SpringSecurity.Service;

import com.dhi.SpringSecurity.Model.Users;
import com.dhi.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private BCryptPasswordEncoder enc= new BCryptPasswordEncoder(12);

    @Autowired
    private UserRepo repo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;

    public Users registerUser(Users users) {
        users.setPassword(enc.encode(users.getPassword()));
        return repo.save(users);
    }

    public String verify(Users users) { //what we are passing is unauthenticated

        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                users.getName(),
                users.getPassword()
        ));
        if(auth.isAuthenticated())
            return jwtService.generateToken(users.getName());
        return "Authentication failed";
    }
}
