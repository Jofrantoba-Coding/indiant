/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.InterestMovementDetail;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoInterestMovementDetail;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSequence;
import com.jofrantoba.model.jdo.shared.UnknownException;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoInterestMovementDetailInsert extends TestBaseDao{    

    @Test
    void createEntity1() throws UnknownException {                
        InterestMovementDetail entity = contextEntity.getBean(InterestMovementDetail.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(InterestMovementDetail.SEQUENCE));           
        InterDaoInterestMovementDetail dao = contextDao.getBean(DaoInterestMovementDetail.class);          
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity2() throws UnknownException {        
        InterestMovementDetail entity = contextEntity.getBean(InterestMovementDetail.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(InterestMovementDetail.SEQUENCE));           
        InterDaoInterestMovementDetail dao = contextDao.getBean(DaoInterestMovementDetail.class);          
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        InterestMovementDetail entity = contextEntity.getBean(InterestMovementDetail.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(InterestMovementDetail.SEQUENCE));           
        InterDaoInterestMovementDetail dao = contextDao.getBean(DaoInterestMovementDetail.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity4() throws UnknownException {
        InterestMovementDetail entity = contextEntity.getBean(InterestMovementDetail.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(InterestMovementDetail.SEQUENCE));           
        InterDaoInterestMovementDetail dao = contextDao.getBean(DaoInterestMovementDetail.class);          
        dao.saveOrUpdate(entity);
    }
}
