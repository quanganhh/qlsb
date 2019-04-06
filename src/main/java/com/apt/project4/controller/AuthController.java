package com.apt.project4.controller;

import com.apt.project4.config.JwtTokenProvider;
import com.apt.project4.config.UserPrincipal;
import com.apt.project4.constant.MessageKeys;
import com.apt.project4.exception.InterlalException;
import com.apt.project4.model.User;
import com.apt.project4.payload.JwtAuthenticationRequest;
import com.apt.project4.payload.JwtAuthenticationResponse;
import com.apt.project4.payload.SingleDataResponse;
import com.apt.project4.payload.UserRegisteringRequest;
import com.apt.project4.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping(value = "/authentication")
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity signin(@Valid @RequestBody JwtAuthenticationRequest requestBody) {
        try {
            String username = requestBody.getUsername();
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, requestBody.getPassword()));
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

            if (!userPrincipal.isActive()) {
                throw new InterlalException(MessageKeys.NEED_ACTIVATE_BY_ADMIN);
            }

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenProvider.generateToken(authentication);
            return ok(new JwtAuthenticationResponse(token, username));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            String message = MessageKeys.USERNAME_OR_PASSWORD_NOT_MATCH;
            if (e instanceof InterlalException) {
                message = e.getMessage();
            }
            throw new BadCredentialsException(message);
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity signUp(@Valid @RequestBody UserRegisteringRequest registerRequest) {
        User savedUser = userService.registerNewAccount(registerRequest);
        return ok(new SingleDataResponse<>(MessageKeys.REGISTER_SUCCESS));
    }

}
