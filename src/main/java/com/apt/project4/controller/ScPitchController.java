/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.controller;

import com.apt.project4.payload.DataListResponse;
import com.apt.project4.service.ScPitchService;
import com.apt.project4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

/**
 *
 * @author toanngo92
 */
@RestController
@RequestMapping("/scfield")
public class ScPitchController {
    @Autowired
    private ScPitchService spService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    
    public ResponseEntity<Object> getAllScPitch() {
        DataListResponse response = new DataListResponse(spService.findAll());
        return ok(response);
    }
}   
