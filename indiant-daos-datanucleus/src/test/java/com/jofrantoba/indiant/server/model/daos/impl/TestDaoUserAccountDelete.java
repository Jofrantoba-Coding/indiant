/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

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
public class TestDaoUserAccountDelete {
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
    void deleteEntity1() throws UnknownException {
        DaoUserAccount dao = new DaoUserAccount();
        dao.delete("chescot2302@gmail.com", "id");
    }

    @Test
    void deleteEntity2() throws UnknownException {
        DaoUserAccount dao = new DaoUserAccount();
        dao.delete("jonathan@kiongo.com", "id");
    }

    @Test
    void deleteEntity3() throws UnknownException {
        DaoUserAccount dao = new DaoUserAccount();
        dao.delete("chescot2302@hotmail.com", "id");
    }
    
    @Test
    void deleteEntity4() throws UnknownException {
        DaoUserAccount dao = new DaoUserAccount();
        dao.delete("jona@hotmail.com", "id");
    }
    
    @Test
    void deleteEntity5() throws UnknownException {
        DaoUserAccount dao = new DaoUserAccount();
        dao.delete("ang2302@yahoo.com", "id");
    }
    
}
