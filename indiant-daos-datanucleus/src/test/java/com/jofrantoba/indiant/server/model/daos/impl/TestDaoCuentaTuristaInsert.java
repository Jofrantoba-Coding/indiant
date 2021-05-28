/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.CuentaTurista;
import com.jofrantoba.indiant.server.model.beans.EstadoCuenta;
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
public class TestDaoCuentaTuristaInsert {
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

    /*@Test
    void createEntity1() throws UnknownException {
        CuentaTurista entity = new CuentaTurista();
        entity.setId("chescot2302@gmail.com");
        entity.setFechaCreacion(new Date());
        DaoEstadoCuenta daoEstadoCuenta=new DaoEstadoCuenta();
        EstadoCuenta beanEstadoCuenta=daoEstadoCuenta.findEntity(null, null, "P");
        entity.setBeanEstadoCuenta(beanEstadoCuenta);
        entity.setCodeEstadoCuenta(beanEstadoCuenta.getId());
        entity.setIsPersistente(Boolean.TRUE);
        entity.setVersion(1L);
        DaoCuentaTurista dao = new DaoCuentaTurista();
        dao.saveOrUpdate(entity);
    }*/
    
    @Test
    void createEntity2() throws UnknownException {        
        DaoCuentaTurista dao = new DaoCuentaTurista();
        String[] fields={"beanEstadoCuenta"};
        CuentaTurista bean=dao.findEntity(fields, 1, "chescot2302@gmail.com");
        System.out.println(bean.getBeanEstadoCuenta().getId());
    }

    /*@Test
    void createEntity2() throws UnknownException {
        CuentaTurista entity = new CuentaTurista();
        entity.setId("jonathan@kiongo.com");        
        entity.setVersion(1L);
        entity.setIsPersistente(Boolean.TRUE);
        DaoCuentaTurista dao = new DaoCuentaTurista();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        CuentaTurista entity = new CuentaTurista();
        entity.setId("chescot2302@hotmail.com");        
        entity.setIsPersistente(Boolean.TRUE);
        entity.setVersion(1L);
        DaoCuentaTurista dao = new DaoCuentaTurista();
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity4() throws UnknownException {
        CuentaTurista entity = new CuentaTurista();
        entity.setId("jona@hotmail.com");        
        entity.setIsPersistente(Boolean.TRUE);
        entity.setVersion(1L);
        DaoCuentaTurista dao = new DaoCuentaTurista();
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void createEntity5() throws UnknownException {
        CuentaTurista entity = new CuentaTurista();
        entity.setId("ang2302@yahoo.com");        
        entity.setIsPersistente(Boolean.TRUE);
        entity.setVersion(1L);
        DaoCuentaTurista dao = new DaoCuentaTurista();
        dao.saveOrUpdate(entity);
    }*/
        
}
