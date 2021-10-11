/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Colony;
import com.jofrantoba.indiant.server.model.beans.Member;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoColony;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoMember;
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
public class TestDaoMemberInsert extends TestBaseDao{
    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    void createEntity1()throws UnknownException {
        Member entity = contextEntity.getBean(Member.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(Colony.SEQUENCE));          
        Point locationLast=new Point(new Position(-73.9667, 40.78));
        entity.setLocation(locationLast);        
        Date creationDate=new Date();
        entity.setUnionDate(creationDate);
        entity.setVersion(creationDate.getTime());
        entity.setIsPersistent(Boolean.TRUE);        
        entity.setIdUser(28L);
        entity.setIdColony(7L);
        Set<ConstraintViolation<Member>> constraintViolations =
                validator.validate( entity );
        if(constraintViolations.isEmpty()){
            InterDaoMember daoColony = contextDao.getBean(DaoMember.class);          
            daoColony.saveOrUpdate(entity);
        }        
    }
    
}
