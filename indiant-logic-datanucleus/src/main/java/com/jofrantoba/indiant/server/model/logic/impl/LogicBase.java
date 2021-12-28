/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.logic.impl;

import com.jofrantoba.indiant.server.model.daos.impl.ConfigDao;
import com.jofrantoba.indiant.server.model.daos.impl.DaoSequence;
import com.jofrantoba.indiant.server.model.daos.impl.DaoUser;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSequence;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoUser;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


/**
 *
 * @author jona
 */
@Log4j2
public class LogicBase {    
    protected AnnotationConfigApplicationContext contextDao = new AnnotationConfigApplicationContext(ConfigDao.class);
    
    @Bean
    private InterDaoUser setUpDaoUser(){
        return contextDao.getBean(DaoUser.class);
    }
    
    @Bean
    private InterDaoSequence setUpDaoSequence(){
        return contextDao.getBean(DaoSequence.class);
    }
    
    @Bean
    private Validator setUpValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}
