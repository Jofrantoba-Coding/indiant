/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Interest;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoInterest;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSequence;
import com.jofrantoba.indiant.server.shared.util.FormatText;
import com.jofrantoba.model.jdo.shared.UnknownException;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoInterestInsert extends TestBaseDao{    

    @Test
    void createEntity1() throws UnknownException {                
        Interest entity = contextEntity.getBean(Interest.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(Interest.SEQUENCE));   
        entity.setDescription(FormatText.firstCapitalLetter("viajes"));
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());
        InterDaoInterest dao = contextDao.getBean(DaoInterest.class);          
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity2() throws UnknownException {        
        Interest entity = contextEntity.getBean(Interest.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(Interest.SEQUENCE));   
        entity.setDescription(FormatText.firstCapitalLetter("oCEO"));
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());
        InterDaoInterest dao = contextDao.getBean(DaoInterest.class);          
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        Interest entity = contextEntity.getBean(Interest.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(Interest.SEQUENCE));   
        entity.setDescription(FormatText.firstCapitalLetter("amisTad"));
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());
        InterDaoInterest dao = contextDao.getBean(DaoInterest.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity4() throws UnknownException {
        Interest entity = contextEntity.getBean(Interest.class);        
        InterDaoSequence daoSequence = contextDao.getBean(DaoSequence.class);          
        entity.set_id(daoSequence.getNextValueId(Interest.SEQUENCE));   
        entity.setDescription(FormatText.firstCapitalLetter("CANOTAJE"));
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());
        InterDaoInterest dao = contextDao.getBean(DaoInterest.class);          
        dao.saveOrUpdate(entity);
    }
}
