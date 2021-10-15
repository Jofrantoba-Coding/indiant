/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Colony;
import com.jofrantoba.indiant.server.model.beans.ColonyInterest;
import com.jofrantoba.indiant.server.model.beans.Interest;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoColony;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoColonyInterest;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoInterest;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSequence;
import com.jofrantoba.model.jdo.shared.UnknownException;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoColonyInterestInsert extends TestBaseDao{
    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    void createEntity1()throws UnknownException {
        ColonyInterest entity = contextEntity.getBean(ColonyInterest.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);
        InterDaoInterest daoInterest = contextDao.getBean(DaoInterest.class);                          
        entity.set_id(daoSequence.getNextValueId(ColonyInterest.SEQUENCE));          
        entity.setStatus("ACT");
        entity.setVersion(new Date().getTime());
        entity.setIsPersistent(Boolean.TRUE);
        entity.setFashionValue(200L);       
        entity.setInterest(daoInterest.find(null, 0, 5l));
        Set<ConstraintViolation<ColonyInterest>> constraintViolations =
                validator.validate( entity );
        if(constraintViolations.isEmpty()){
            InterDaoColonyInterest daoColony = contextDao.getBean(DaoColonyInterest.class);                
            daoColony.saveOrUpdate(entity);
        }        
    }
    
}
