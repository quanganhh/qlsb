package com.apt.project4.controller;

import com.apt.project4.constant.MessageKeys;
import com.apt.project4.model.User;
import com.apt.project4.payload.DataListResponse;
import com.apt.project4.payload.SingleDataResponse;
import com.apt.project4.payload.UserRegisteringRequest;
import com.apt.project4.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.RequestBody;

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
    //add new User
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addNewUser(@Valid @RequestBody UserRegisteringRequest userRequestobj){
        User user = userService.addNewUser(userRequestobj);
         return ok(new SingleDataResponse<>(MessageKeys.REGISTER_SUCCESS));
    }
    
    //update user
    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public ResponseEntity updateUser(@Valid @RequestBody UserRegisteringRequest userRequestobj){
        User user = userService.updateUser(userRequestobj);
        return ok(new SingleDataResponse<>(MessageKeys.UPDATE_SUCCESS));
    }
}
