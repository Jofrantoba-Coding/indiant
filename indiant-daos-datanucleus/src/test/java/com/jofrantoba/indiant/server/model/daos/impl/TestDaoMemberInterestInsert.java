/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Colony;
import com.jofrantoba.indiant.server.model.beans.MemberInterest;
import com.jofrantoba.indiant.server.model.beans.Interest;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoColony;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoMemberInterest;
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
public class TestDaoMemberInterestInsert extends TestBaseDao{
    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    void createEntity1()throws UnknownException {
        MemberInterest entity = contextEntity.getBean(MemberInterest.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);
        InterDaoInterest daoInterest = contextDao.getBean(DaoInterest.class);                          
        entity.set_id(daoSequence.getNextValueId(MemberInterest.SEQUENCE));          
        entity.setStatus("ACT");
        entity.setVersion(new Date().getTime());
        entity.setIsPersistent(Boolean.TRUE);
        entity.setFashionValue(200L);       
        entity.setInterest(daoInterest.find(null, 0, 5l));  
        entity.setIdUser(30l);
        entity.setIdColony(11l);
        entity.setIdMember(1l);
        Set<ConstraintViolation<MemberInterest>> constraintViolations =
                validator.validate( entity );
        //if(constraintViolations.isEmpty()){
            InterDaoMemberInterest daoMemberInterest = contextDao.getBean(DaoMemberInterest.class);                
            daoMemberInterest.saveOrUpdate(entity);
        //}        
    }
    
}
