/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.spark.api;

import com.jofrantoba.indiant.spark.beans.Count;
import com.jofrantoba.indiant.spark.service.InterServiceCreateColony;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jona
 */
@RestController
public class ApiCreateColony implements InterApiCreateColony{
    
    @Autowired
    private InterServiceCreateColony serviceCreateColony;
    
    @GetMapping("/createColony/{idColony}")
    @Override
    public ResponseEntity<String> taskCreateColony(@PathVariable Long idColony) {
        return serviceCreateColony.taskCreateColony(idColony);
    }
    
    @GetMapping("wordcount")
    public ResponseEntity<List<Count>> words() {
        return new ResponseEntity<>(serviceCreateColony.count(), HttpStatus.OK);
    }
    
}
