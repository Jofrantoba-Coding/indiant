/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.MovementType;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoMovementType;
import com.jofrantoba.model.jdo.shared.UnknownException;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoMovementTypeInsert extends TestBaseDao{    

    @Test
    void createEntity1() throws UnknownException {        
        MovementType entity = contextEntity.getBean(MovementType.class);
        entity.set_id("CC");
        entity.setDescription("CREATE COLONY");        
        entity.setStatus("ACT");
        entity.setType("INPUT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());         
        InterDaoMovementType dao = contextDao.getBean(DaoMovementType.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity2() throws UnknownException {        
        MovementType entity = contextEntity.getBean(MovementType.class);
        entity.set_id("JC");
        entity.setDescription("JOIN COLONY");        
        entity.setStatus("ACT");
        entity.setType("INPUT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());         
        InterDaoMovementType dao = contextDao.getBean(DaoMovementType.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity3() throws UnknownException {        
        MovementType entity = contextEntity.getBean(MovementType.class);
        entity.set_id("EPC");
        entity.setDescription("ENTER THE PERIMETER OF THE COLONY");        
        entity.setStatus("ACT");
        entity.setType("INPUT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());         
        InterDaoMovementType dao = contextDao.getBean(DaoMovementType.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity4() throws UnknownException {        
        MovementType entity = contextEntity.getBean(MovementType.class);
        entity.set_id("EAM");
        entity.setDescription("EMPATHY AMONG MEMBERS");        
        entity.setStatus("ACT");
        entity.setType("INPUT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());         
        InterDaoMovementType dao = contextDao.getBean(DaoMovementType.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity5() throws UnknownException {        
        MovementType entity = contextEntity.getBean(MovementType.class);
        entity.set_id("ANE");
        entity.setDescription("ACCEPT NOTIFICATION OF EMPATHY");        
        entity.setStatus("ACT");
        entity.setType("INPUT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());         
        InterDaoMovementType dao = contextDao.getBean(DaoMovementType.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity6() throws UnknownException {        
        MovementType entity = contextEntity.getBean(MovementType.class);
        entity.set_id("RNE");
        entity.setDescription("REJECT NOTIFICATION OF EMPATHY");        
        entity.setStatus("ACT");
        entity.setType("NEUTRAL");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());         
        InterDaoMovementType dao = contextDao.getBean(DaoMovementType.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity7() throws UnknownException {        
        MovementType entity = contextEntity.getBean(MovementType.class);
        entity.set_id("WPC");
        entity.setDescription("WITHDRAWAL FROM THE PERIMETER OF THE COLONY");        
        entity.setStatus("ACT");
        entity.setType("OUTPUT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());         
        InterDaoMovementType dao = contextDao.getBean(DaoMovementType.class);          
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity8() throws UnknownException {        
        MovementType entity = contextEntity.getBean(MovementType.class);
        entity.set_id("LC");
        entity.setDescription("LEAVE COLONY");        
        entity.setStatus("ACT");
        entity.setType("OUTPUT");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());         
        InterDaoMovementType dao = contextDao.getBean(DaoMovementType.class);          
        dao.saveOrUpdate(entity);
    }

    
}
