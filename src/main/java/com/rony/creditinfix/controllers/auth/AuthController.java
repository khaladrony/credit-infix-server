package com.rony.creditinfix.controllers.auth;

import com.rony.creditinfix.models.JwtRequest;
import com.rony.creditinfix.models.JwtResponse;
import com.rony.creditinfix.security.JwtHelper;
import com.rony.creditinfix.services.JwtUserDetailsService;
import com.rony.creditinfix.services.util.ShowAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@ShowAPI
@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        this.doAuthenticate(request.getUsername(), request.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String token = this.jwtHelper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    private void doAuthenticate(String username, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        try {
            authenticationManager.authenticate(token);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid username or password.");

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credential Invalid!";
    }
}
