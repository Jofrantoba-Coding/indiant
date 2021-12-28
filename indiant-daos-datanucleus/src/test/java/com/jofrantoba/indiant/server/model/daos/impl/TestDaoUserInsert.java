/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Interest;
import com.jofrantoba.indiant.server.model.beans.User;
import com.jofrantoba.indiant.server.model.beans.UserInterest;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoAccountStatus;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoInterest;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSequence;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoUser;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoUserInterest;
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
public class TestDaoUserInsert extends TestBaseDao{
    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    void createEntity1()throws UnknownException {
        User entity = contextEntity.getBean(User.class);        
        UserInterest userInterest = contextEntity.getBean(UserInterest.class);                
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);         
        InterDaoInterest daoInterest = contextDao.getBean(DaoInterest.class);
        InterDaoAccountStatus daoAccountStatus=contextDao.getBean(DaoAccountStatus.class);
        InterDaoUserInterest daoUserInterest = contextDao.getBean(DaoUserInterest.class);                
        InterDaoUser daoUser = contextDao.getBean(DaoUser.class);          
        
        Long idUser=daoSequence.getNextValueId(User.SEQUENCE);
        entity.set_id(idUser);  
        entity.setEmail("jnas2302@gmail.com");
        Point locationLast=new Point(new Position(-73.9667, 40.78));
        entity.setLocationLast(locationLast);   
        Date creationDate=new Date();
        entity.setVersion(creationDate.getTime());
        entity.setIsPersistent(Boolean.TRUE);                        
        entity.setAccountStatus(daoAccountStatus.detach(daoAccountStatus.find("PEN")));
        
        /*userInterest.set_id(daoSequence.getNextValueId(UserInterest.SEQUENCE));          
        userInterest.setStatus("ACT");
        userInterest.setVersion(new Date().getTime());
        userInterest.setIsPersistent(Boolean.TRUE);
        userInterest.setFashionValue(200L);       
        userInterest.setInterest(daoInterest.find(null, 0, 1l));          
        userInterest.setIdUser(idUser);                                            
        entity.getUserInterest().add(daoUserInterest.saveOrUpdateReturn(userInterest,true));*/
        daoUser.saveOrUpdate(entity);
        
        
        /*DaoUserInterest dao = new DaoUserInterest();         
        UserInterest item=dao.find(1l);
        Interest inter=(Interest)dao.detachObject(item.getInterest());
        item=dao.detach(item);
        dao.closePm();
        entity.getUserInterest().add(item);
        Set<ConstraintViolation<User>> constraintViolations =
                validator.validate( entity );*/
        //if(constraintViolations.isEmpty()){
            //InterDaoUser daoUser = contextDao.getBean(DaoUser.class);          
            //daoUser.saveOrUpdate(entity);
        //}        
    }
    
}
