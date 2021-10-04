/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.FriendRequestStatus;
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
@Log4j2
public class TestDaoFriendRequestStatusInsert {
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
        FriendRequestStatus entity = new FriendRequestStatus();
        entity.setId("R");
        entity.setDescription("RECHAZADA");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion(1L);
        DaoFriendRequestStatus dao = new DaoFriendRequestStatus();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity2() throws UnknownException {
        FriendRequestStatus entity = new FriendRequestStatus();
        entity.setId("P");
        entity.setDescription("PENDIENTE");
        entity.setVersion(1L);
        entity.setIsPersistent(Boolean.TRUE);
        DaoFriendRequestStatus dao = new DaoFriendRequestStatus();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        FriendRequestStatus entity = new FriendRequestStatus();
        entity.setId("A");
        entity.setDescription("ACEPTADA");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion(1L);
        DaoFriendRequestStatus dao = new DaoFriendRequestStatus();
        dao.saveOrUpdate(entity);
    }
        
}
