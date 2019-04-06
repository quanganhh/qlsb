/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.controller;

import com.apt.project4.constant.MessageKeys;
import com.apt.project4.model.ScPitch;
import com.apt.project4.payload.DataListResponse;
import com.apt.project4.payload.ScPtichAddNewRequest;
import com.apt.project4.payload.SingleDataResponse;
import com.apt.project4.service.ScPitchService;
import com.apt.project4.service.UserService;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getScPitchbyId(@PathVariable String id) {
        Integer scId = parseInt(id);
        SingleDataResponse response = new SingleDataResponse(spService.findById(scId));
        return ok(response);
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addNewScField(@Valid @RequestBody ScPtichAddNewRequest scPitchRequestobj){
        ScPitch sp = spService.addNewScPitch(scPitchRequestobj);
         return ok(new SingleDataResponse<>(MessageKeys.REGISTER_SUCCESS));
    }
}
