/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.spark.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author jona
 */
@Service
public class ServiceCreateColony implements InterServiceCreateColony{

    @Override
    public ResponseEntity<String> taskCreateColony(Long idColony) {
        /*Implemetar codigo spark*/
        return new ResponseEntity<>("Background create colony:"+idColony, HttpStatus.OK);
    }
    
}
