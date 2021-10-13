/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.PrivacyLevel;
import com.jofrantoba.model.jdo.shared.UnknownException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
@Log4j2
public class TestDaoPrivacyLevelInsert {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void createEntity1() throws UnknownException {
        PrivacyLevel entity = new PrivacyLevel();
        entity.set_id("ME");
        entity.setDescription("JUST ME");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion(new Date().getTime());
        entity.setStatus("ACT");
        DaoPrivacyLevel dao = new DaoPrivacyLevel();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity2() throws UnknownException {
        PrivacyLevel entity = new PrivacyLevel();
        entity.set_id("PU");
        entity.setDescription("PUBLIC");
        entity.setVersion(new Date().getTime());
        entity.setStatus("ACT");
        entity.setIsPersistent(Boolean.TRUE);
        DaoPrivacyLevel dao = new DaoPrivacyLevel();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        PrivacyLevel entity = new PrivacyLevel();
        entity.set_id("MC");
        entity.setDescription("MEMBER OF MY COLONIES");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion(new Date().getTime());
        entity.setStatus("ACT");
        DaoPrivacyLevel dao = new DaoPrivacyLevel();
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity4() throws UnknownException {
        PrivacyLevel entity = new PrivacyLevel();
        entity.set_id("FR");
        entity.setDescription("FRIENDS");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion(new Date().getTime());
        entity.setStatus("ACT");
        DaoPrivacyLevel dao = new DaoPrivacyLevel();
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity5() throws UnknownException {
        PrivacyLevel entity = new PrivacyLevel();
        entity.set_id("FF");
        entity.setDescription("FRIENDS OF MY FRIENDS");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion(new Date().getTime());
        entity.setStatus("ACT");
        DaoPrivacyLevel dao = new DaoPrivacyLevel();
        dao.saveOrUpdate(entity);
    }
        
}
