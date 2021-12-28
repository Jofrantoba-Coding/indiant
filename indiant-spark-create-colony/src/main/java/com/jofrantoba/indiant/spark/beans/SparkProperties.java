/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.spark.beans;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author jona
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "spark")
public class SparkProperties {
    @NotNull
    @Value("${spark.app.name}")
    private String sparkAppName;
    @NotNull
    @Value("${spark.master}")
    private String sparkMaster;
    @NotNull
    @Value("${spark.driver.memory}")
    private String sparkDriverMemory;
    @NotNull
    @Value("${spark.worker.memory}")
    private String sparkWorkerMemory;
    @NotNull
    @Value("${spark.executor.memory}")
    private String sparkExecutorMemory;
    @NotNull
    @Value("${spark.rpc.message.maxSize}")
    private String sparkRpcMessageMaxSize;
    @NotNull
    @Value("${spark.dynamicAllocation.enabled}")
    private String sparkDynamicAllocationEnabled;
    @NotNull
    @Value("${spark.driver.host}")
    private String sparkDriverHost;
    @NotNull
    @Value("${spark.sql.autoBroadcastJoinThreshold}")
    private String sparkSqlAutoBroadcastJoinThreshold;    
}
