/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.MemberStatus;
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
public class TestDaoMemberStatusInsert {
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
        MemberStatus entity = new MemberStatus();
        entity.set_id("RET");
        entity.setDescription("RETIRED");        
        entity.setObservation("OUTSIDE THE RANGE OF THE COLONY");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setStatus("ACT");
        entity.setVersion(new Date().getTime());        
        DaoMemberStatus dao = new DaoMemberStatus();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity2() throws UnknownException {
        MemberStatus entity = new MemberStatus();
        entity.set_id("DEA");
        entity.setDescription("DEACTIVATE");
        entity.setObservation("LEFT THE COLONY BY DECISION");
        entity.setStatus("ACT");
        entity.setVersion(new Date().getTime());        
        entity.setIsPersistent(Boolean.TRUE);
        DaoMemberStatus dao = new DaoMemberStatus();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        MemberStatus entity = new MemberStatus();
        entity.set_id("ACT");
        entity.setDescription("ACTIVE");
        entity.setObservation("WITHIN THE RANGE OF THE COLONY");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setStatus("ACT");
        entity.setVersion(new Date().getTime());        
        DaoMemberStatus dao = new DaoMemberStatus();
        dao.saveOrUpdate(entity);
    }
        
}
