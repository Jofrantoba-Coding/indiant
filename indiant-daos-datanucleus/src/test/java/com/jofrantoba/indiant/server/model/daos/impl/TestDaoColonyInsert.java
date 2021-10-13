/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Colony;
import com.jofrantoba.indiant.server.model.beans.Interest;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoColony;
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
public class TestDaoColonyInsert extends TestBaseDao{
    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    void createEntity1()throws UnknownException {
        Colony entity = contextEntity.getBean(Colony.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);                          
        entity.set_id(daoSequence.getNextValueId(Colony.SEQUENCE));          
        Point locationLast=new Point(new Position(-73.9667, 40.78));
        entity.setLocation(locationLast);
        entity.setName("C"+entity.get_id());
        entity.setRadius(500.50);
        Date creationDate=new Date();
        entity.setCreationDate(creationDate);
        entity.setVersion(creationDate.getTime());
        entity.setIsPersistent(Boolean.TRUE);        
        entity.setCreaterIdUser(28L);
        Set<ConstraintViolation<Colony>> constraintViolations =
                validator.validate( entity );
        if(constraintViolations.isEmpty()){
            InterDaoColony daoColony = contextDao.getBean(DaoColony.class);                
            daoColony.saveOrUpdate(entity);
        }        
    }
    
}
