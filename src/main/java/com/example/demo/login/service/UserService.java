package com.example.demo.login.service;

import com.example.demo.login.entity.User;
import com.example.demo.login.exception.UserException;
import com.example.demo.login.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public String login(String email,String password) throws UserException{
        Optional<User> user=UserRepository.findByEmail(email);
        String passwordEncoder1=passwordEncoder.encode(password);
        if(user.isPresent() && passwordEncoder1.equals(user.get().getPassword())){
            //Jetonul JWT semnat cu HMAC
            String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
            Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                    SignatureAlgorithm.HS256.getJcaName());
            String jwt= Jwts.builder()
                    .claim("id",user.get().getPassword())
                    .claim("name",user.get().getName())
                    .claim("email",user.get().getEmail())
                    .claim("password",user.get().getPassword())
                    .claim("speciality",user.get().getSpeciality())
                    .setSubject("user")
                    .setIssuedAt(Date.from(Instant.now()))
                    .setExpiration(Date.from(Instant.now().plus(5l, ChronoUnit.MINUTES)))
                    .signWith(hmacKey)
                    .compact();
            return jwt;
        }else{
            throw new UserException("Please check your password and account name and try again");
        }
    }
}
