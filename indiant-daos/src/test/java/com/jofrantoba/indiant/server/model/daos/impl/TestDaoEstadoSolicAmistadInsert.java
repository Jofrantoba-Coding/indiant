/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.EstadoSolicAmistad;
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
public class TestDaoEstadoSolicAmistadInsert {
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
        EstadoSolicAmistad entity = new EstadoSolicAmistad();
        entity.setId("R");
        entity.setDescripcion("RECHAZADA");
        entity.setIsPersistente(Boolean.TRUE);
        entity.setVersion(1L);
        DaoEstadoSolicAmistad dao = new DaoEstadoSolicAmistad();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity2() throws UnknownException {
        EstadoSolicAmistad entity = new EstadoSolicAmistad();
        entity.setId("P");
        entity.setDescripcion("PENDIENTE");
        entity.setVersion(1L);
        entity.setIsPersistente(Boolean.TRUE);
        DaoEstadoSolicAmistad dao = new DaoEstadoSolicAmistad();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        EstadoSolicAmistad entity = new EstadoSolicAmistad();
        entity.setId("A");
        entity.setDescripcion("ACEPTADA");
        entity.setIsPersistente(Boolean.TRUE);
        entity.setVersion(1L);
        DaoEstadoSolicAmistad dao = new DaoEstadoSolicAmistad();
        dao.saveOrUpdate(entity);
    }
        
}
