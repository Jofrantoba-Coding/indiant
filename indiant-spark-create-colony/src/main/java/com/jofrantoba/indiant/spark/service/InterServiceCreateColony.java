/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.spark.service;

import com.jofrantoba.indiant.spark.beans.Count;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jona
 */
public interface InterServiceCreateColony {
    ResponseEntity<String> taskCreateColony(Long idColony);
    List<Count> count();
}
