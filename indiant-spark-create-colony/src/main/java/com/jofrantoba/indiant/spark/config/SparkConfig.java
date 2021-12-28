/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.spark.config;

import com.jofrantoba.indiant.spark.beans.SparkProperties;
import lombok.RequiredArgsConstructor;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author jona
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(SparkProperties.class)
public class SparkConfig {

    private final SparkProperties sparkProperties;

    @Autowired
    @Bean("sparkConf")
    public SparkConf sparkConf() {
        SparkConf conf = new SparkConf()
                .setAppName(sparkProperties.getSparkAppName())
                .setMaster(sparkProperties.getSparkMaster())             
                        .set("spark.driver.memory",sparkProperties.getSparkDriverMemory())
                        .set("spark.worker.memory",sparkProperties.getSparkWorkerMemory())
                        .set("spark.executor.memory",sparkProperties.getSparkExecutorMemory())
                        .set("spark.rpc.message.maxSize",sparkProperties.getSparkRpcMessageMaxSize())
                        .set("spark.driver.host",sparkProperties.getSparkDriverHost())
                        .set("spark.sql.autoBroadcastJoinThreshold",sparkProperties.getSparkSqlAutoBroadcastJoinThreshold());
                        //.set("spark.dynamicAllocation.enabled",sparkProperties.getSparkDynamicAllocationEnabled());
                //.setMaster("local[*]");//just use in test
        return conf;
    }

    @Autowired
    @Bean("javaSparkContext")
    public JavaSparkContext javaSparkContext(@Qualifier("sparkConf") SparkConf sparkConf) {
        return new JavaSparkContext(sparkConf);
    }

    @Autowired
    @Bean("sparkSession")
    public SparkSession sparkSession(@Qualifier("javaSparkContext") JavaSparkContext javaSparkContext) {
        return SparkSession
                .builder()
                .sparkContext(javaSparkContext.sc())
                .appName(sparkProperties.getSparkAppName())
                //.config("spark.mongodb.input.uri", "mongodb://mtoral:Maej1019@ec2-35-163-220-126.us-west-2.compute.amazonaws.com:27017,ec2-34-222-157-77.us-west-2.compute.amazonaws.com:27017/colhum.Colony")
                //.config("spark.mongodb.output.uri", "mongodb://mtoral:Maej1019@ec2-35-163-220-126.us-west-2.compute.amazonaws.com:27017,ec2-34-222-157-77.us-west-2.compute.amazonaws.com:27017/colhum.Colony")
                //.config("spark.mongodb.input.uri", "mongodb://mtoral:Maej1019@ec2-35-163-220-126.us-west-2.compute.amazonaws.com:27017/colhum.Colony")
                //.config("spark.mongodb.output.uri", "mongodb://mtoral:Maej1019@ec2-35-163-220-126.us-west-2.compute.amazonaws.com:27017/colhum.Colony")
                .getOrCreate();
    }

    @Autowired
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
