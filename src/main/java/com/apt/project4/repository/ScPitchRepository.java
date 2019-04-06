/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apt.project4.repository;
import com.apt.project4.model.ScPitch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author toanngo92
 */
public interface ScPitchRepository extends JpaRepository<ScPitch, Integer> {
    
}
