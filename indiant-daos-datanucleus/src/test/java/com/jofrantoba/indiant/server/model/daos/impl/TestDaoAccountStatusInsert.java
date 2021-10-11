/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.AccountStatus;
import com.jofrantoba.model.jdo.shared.UnknownException;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoAccountStatusInsert extends TestBaseDao{    

    @Test
    void createEntity1() throws UnknownException {
        AccountStatus entity = new AccountStatus();
        entity.set_id("PEN");
        entity.setDescription("PENDING");
        entity.setObservation("PENDING ACTIVATION (FIRST STATEMENT OF ACCOUNT)");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity2() throws UnknownException {
        AccountStatus entity = new AccountStatus();
        entity.set_id("DEL");
        entity.setDescription("DELETED");
        entity.setObservation("DELETED (USER DELETES THEIR ACCOUNT)");
        entity.setVersion((new Date()).getTime());
        entity.setIsPersistent(Boolean.TRUE);
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        AccountStatus entity = new AccountStatus();
        entity.set_id("DEA");
        entity.setDescription("DEACTIVATED");
        entity.setObservation("DEACTIVATED (USER DEACTIVATES THEIR ACCOUNT TEMPORARILY AND CAN RE-ACTIVATE IT)");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity4() throws UnknownException {
        AccountStatus entity = new AccountStatus();
        entity.set_id("ACT");
        entity.setDescription("ACTIVATED");
        entity.setObservation("ACTIVATED (CAN BE PASSED FROM STATES: PENDING AND DEACTIVATED)");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion((new Date()).getTime());
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.saveOrUpdate(entity);
    }
}
