/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.service;

import com.apt.project4.model.ScPitch;
import com.apt.project4.payload.ScPtichAddNewRequest;
import com.apt.project4.payload.UserRegisteringRequest;
import com.apt.project4.repository.ScPitchRepository;
import com.apt.project4.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author toanngo92
 */

@Service
@Transactional
public class ScPitchService {
    private final static Logger LOGGER = LoggerFactory.getLogger(ScPitchService.class);
    @Autowired
    private ScPitchRepository scPitchRepository;
    @Autowired
    private ObjectMapper objectMapper;
    public ScPitch findById(Integer sfId ){
        return scPitchRepository.findById(sfId).orElse(null);
    }
    public List<ScPitch> findAll() {
        return scPitchRepository.findAll();
    }
    public ScPitch addNewScPitch(ScPtichAddNewRequest scPitchRequestobj){
        ScPitch sp = objectMapper.convertValue(scPitchRequestobj, ScPitch.class);
        return scPitchRepository.save(sp);
    }
    
    
}
