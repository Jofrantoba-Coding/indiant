/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.AccountStatus;
import com.jofrantoba.model.jdo.shared.UnknownException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoAccountStatusInsert extends TestBaseDao{    

    @Test
    void createEntity1() throws UnknownException {
        AccountStatus entity = new AccountStatus();
        entity.setId("PEN");
        entity.setDescription("PENDING");
        entity.setObservation("PENDING ACTIVATION (FIRST STATEMENT OF ACCOUNT)");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion(1L);
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity2() throws UnknownException {
        AccountStatus entity = new AccountStatus();
        entity.setId("DEL");
        entity.setDescription("DELETED");
        entity.setObservation("DELETED (USER DELETES THEIR ACCOUNT)");
        entity.setVersion(1L);
        entity.setIsPersistent(Boolean.TRUE);
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        AccountStatus entity = new AccountStatus();
        entity.setId("DEA");
        entity.setDescription("DEACTIVATED");
        entity.setObservation("DEACTIVATED (USER DEACTIVATES THEIR ACCOUNT TEMPORARILY AND CAN RE-ACTIVATE IT)");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion(1L);
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity4() throws UnknownException {
        AccountStatus entity = new AccountStatus();
        entity.setId("ACT");
        entity.setDescription("ACTIVATED");
        entity.setObservation("ACTIVATED (CAN BE PASSED FROM STATES: PENDING AND DEACTIVATED)");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion(1L);
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.saveOrUpdate(entity);
    }
}
