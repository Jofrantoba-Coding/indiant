/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Colony;
import com.jofrantoba.indiant.server.model.beans.Interest;
import com.jofrantoba.indiant.server.model.beans.InterestMovementDetail;
import com.jofrantoba.indiant.server.model.beans.Member;
import com.jofrantoba.indiant.server.model.beans.MovementInterest;
import com.jofrantoba.indiant.server.model.beans.Sequence;
import com.jofrantoba.indiant.server.model.beans.User;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSequence;
import com.jofrantoba.model.jdo.shared.UnknownException;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoSequenceInsert extends TestBaseDao{
    
    @Test
    void createEntity1() throws UnknownException {                
        Sequence entity = contextEntity.getBean(Sequence.class);        
        entity.set_id(Interest.SEQUENCE); 
        entity.setNextValue(1L);
        entity.setStatus("ACT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());
        InterDaoSequence dao = contextDao.getBean(DaoSequence.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity2() throws UnknownException {                
        Sequence entity = contextEntity.getBean(Sequence.class);        
        entity.set_id(User.SEQUENCE); 
        entity.setNextValue(1L);
        entity.setStatus("ACT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());
        InterDaoSequence dao = contextDao.getBean(DaoSequence.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity3() throws UnknownException {                
        Sequence entity = contextEntity.getBean(Sequence.class);        
        entity.set_id(Colony.SEQUENCE); 
        entity.setNextValue(1L);
        entity.setStatus("ACT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());
        InterDaoSequence dao = contextDao.getBean(DaoSequence.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity4() throws UnknownException {                
        Sequence entity = contextEntity.getBean(Sequence.class);        
        entity.set_id(Member.SEQUENCE); 
        entity.setNextValue(1L);
        entity.setStatus("ACT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());
        InterDaoSequence dao = contextDao.getBean(DaoSequence.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity5() throws UnknownException {                
        Sequence entity = contextEntity.getBean(Sequence.class);        
        entity.set_id(MovementInterest.SEQUENCE); 
        entity.setNextValue(1L);
        entity.setStatus("ACT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());        
        InterDaoSequence dao = contextDao.getBean(DaoSequence.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity6() throws UnknownException {                
        Sequence entity = contextEntity.getBean(Sequence.class);        
        entity.set_id(InterestMovementDetail.SEQUENCE); 
        entity.setNextValue(1L);
        entity.setStatus("ACT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());        
        InterDaoSequence dao = contextDao.getBean(DaoSequence.class);          
        dao.saveOrUpdate(entity);
    }

}
