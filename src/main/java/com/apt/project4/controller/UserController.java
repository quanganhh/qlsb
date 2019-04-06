package com.apt.project4.controller;

import com.apt.project4.payload.DataListResponse;
import com.apt.project4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsers() {
        DataListResponse response = new DataListResponse(userService.findAll());
        return ok(response);
    }
}
