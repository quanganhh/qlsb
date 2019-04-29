package com.apt.project4.controller;

import com.apt.project4.constant.MessageKeys;
import com.apt.project4.model.User;
import com.apt.project4.payload.DataListResponse;
import com.apt.project4.payload.SingleDataResponse;
import com.apt.project4.payload.UserRegisteringRequest;
import com.apt.project4.service.UserService;
import static java.lang.Integer.parseInt;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    // Get user by id
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable String id) {
        Integer userId = parseInt(id);
        SingleDataResponse response = new SingleDataResponse(userService.findById(userId));
        return ok(response);
    }

    //add new User
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addNewUser(@Valid @RequestBody UserRegisteringRequest userRequestobj) {
        User user = userService.addNewUser(userRequestobj);
        return ok(new SingleDataResponse<>(MessageKeys.REGISTER_SUCCESS));
    }

    //update user
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@Valid @RequestBody UserRegisteringRequest userRequestobj) {
        User user = userService.updateUser(userRequestobj);
        return ok(new SingleDataResponse<>(MessageKeys.UPDATE_SUCCESS));
    }

    //delete user
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        //return ok(new SingleDataResponse<>(MessageKeys.DELETE_SUCCESS));
    }
}
