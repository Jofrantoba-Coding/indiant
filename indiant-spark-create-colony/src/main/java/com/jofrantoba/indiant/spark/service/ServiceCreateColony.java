/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.spark.service;

import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author jona
 */
@Service
public class ServiceCreateColony implements InterServiceCreateColony{
    
    @Autowired
    private SparkSession sparkSession;

    @Override
    public ResponseEntity<String> taskCreateColony(Long idColony) {
        /*Implemetar codigo spark*/
        JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());
        JavaMongoRDD<Document> rdd = MongoSpark.load(jsc);
        System.out.println(rdd.count());
        System.out.println(rdd.first().toJson());
        jsc.close();
        return new ResponseEntity<>("Background create colony:"+idColony, HttpStatus.OK);
    }
    
}
