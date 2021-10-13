/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.MovementInterest;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoMovementInterest;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSequence;
import com.jofrantoba.indiant.server.shared.util.FormatText;
import com.jofrantoba.model.jdo.shared.UnknownException;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoMovementInterestInsert extends TestBaseDao{    

    @Test
    void createEntity1() throws UnknownException {                
        MovementInterest entity = contextEntity.getBean(MovementInterest.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(MovementInterest.SEQUENCE));                   
        InterDaoMovementInterest dao = contextDao.getBean(DaoMovementInterest.class);          
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity2() throws UnknownException {        
        MovementInterest entity = contextEntity.getBean(MovementInterest.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(MovementInterest.SEQUENCE));                  
        InterDaoMovementInterest dao = contextDao.getBean(DaoMovementInterest.class);          
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        MovementInterest entity = contextEntity.getBean(MovementInterest.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(MovementInterest.SEQUENCE));                   
        InterDaoMovementInterest dao = contextDao.getBean(DaoMovementInterest.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity4() throws UnknownException {
        MovementInterest entity = contextEntity.getBean(MovementInterest.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(MovementInterest.SEQUENCE));           
        InterDaoMovementInterest dao = contextDao.getBean(DaoMovementInterest.class);          
        dao.saveOrUpdate(entity);
    }
}
