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
public class TestDaoColonyInsert extends TestBaseDao{
    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    void createEntity1()throws UnknownException {
        ColonyInterest entityColonyInterest = contextEntity.getBean(ColonyInterest.class);        
        Colony entityColony = contextEntity.getBean(Colony.class);                                
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);
        InterDaoInterest daoInterest = contextDao.getBean(DaoInterest.class);             
        entityColony.set_id(daoSequence.getNextValueId(Colony.SEQUENCE));          
        entityColonyInterest.setIdColony(entityColony.get_id());
        entityColonyInterest.set_id(daoSequence.getNextValueId(ColonyInterest.SEQUENCE));          
        entityColonyInterest.setStatus("ACT");
        entityColonyInterest.setVersion(new Date().getTime());
        entityColonyInterest.setIsPersistent(Boolean.TRUE);
        entityColonyInterest.setFashionValue(1L);       
        entityColonyInterest.setInterest(daoInterest.find(null, 0, 5l));        
        Set<ConstraintViolation<ColonyInterest>> constraintViolations =
                validator.validate( entityColonyInterest );
        if(constraintViolations.isEmpty()){
            InterDaoColonyInterest daoColonyInterest = contextDao.getBean(DaoColonyInterest.class);                
            entityColonyInterest=daoColonyInterest.saveOrUpdateReturn(entityColonyInterest,true);
        }                        
        daoSequence.closePm();
        Point locationLast=new Point(new Position(-73.9667, 40.78));
        entityColony.setLocation(locationLast);
        entityColony.setName("C"+entityColony.get_id());
        entityColony.setRadius(500.50);
        Date creationDate=new Date();
        entityColony.setCreationDate(creationDate);
        entityColony.setVersion(creationDate.getTime());
        entityColony.setIsPersistent(Boolean.TRUE);        
        entityColony.setCreaterIdUser(3L);
        /*DaoColonyInterest dao = new DaoColonyInterest();         
        ColonyInterest item=dao.find(23l);
        Interest inter=(Interest)dao.detachObject(item.getInterest());
        item=dao.detach(item);
        dao.closePm();*/
        entityColony.getColonyInterest().add(entityColonyInterest);
        /*Set<ConstraintViolation<Colony>> constraintViolations =
                validator.validate( entityColony );*/
        //if(constraintViolations.isEmpty()){
            DaoColony daoColony = contextDao.getBean(DaoColony.class);         
            daoColony.saveOrUpdate(entityColony);
        //}        
    }
    
}
