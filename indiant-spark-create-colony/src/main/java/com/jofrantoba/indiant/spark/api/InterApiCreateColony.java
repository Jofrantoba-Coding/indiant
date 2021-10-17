/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.spark.api;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author jona
 */
public interface InterApiCreateColony{
    ResponseEntity<String> taskCreateColony(Long idColony);
}
