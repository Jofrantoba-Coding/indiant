/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Privacidad;
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
public class TestDaoPrivacidadInsert {
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
        Privacidad entity = new Privacidad();
        entity.setId("SY");
        entity.setDescripcion("SOLO YO");
        entity.setIsPersistente(Boolean.TRUE);
        entity.setVersion(1L);
        DaoPrivacidad dao = new DaoPrivacidad();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity2() throws UnknownException {
        Privacidad entity = new Privacidad();
        entity.setId("PB");
        entity.setDescripcion("PUBLICO");
        entity.setVersion(1L);
        entity.setIsPersistente(Boolean.TRUE);
        DaoPrivacidad dao = new DaoPrivacidad();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        Privacidad entity = new Privacidad();
        entity.setId("MC");
        entity.setDescripcion("MIEMBRO DE MIS COLONIAS");
        entity.setIsPersistente(Boolean.TRUE);
        entity.setVersion(1L);
        DaoPrivacidad dao = new DaoPrivacidad();
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity4() throws UnknownException {
        Privacidad entity = new Privacidad();
        entity.setId("AM");
        entity.setDescripcion("AMIGOS");
        entity.setIsPersistente(Boolean.TRUE);
        entity.setVersion(1L);
        DaoPrivacidad dao = new DaoPrivacidad();
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity5() throws UnknownException {
        Privacidad entity = new Privacidad();
        entity.setId("AA");
        entity.setDescripcion("AMIGOS DE MIS AMIGOS");
        entity.setIsPersistente(Boolean.TRUE);
        entity.setVersion(1L);
        DaoPrivacidad dao = new DaoPrivacidad();
        dao.saveOrUpdate(entity);
    }
        
}
