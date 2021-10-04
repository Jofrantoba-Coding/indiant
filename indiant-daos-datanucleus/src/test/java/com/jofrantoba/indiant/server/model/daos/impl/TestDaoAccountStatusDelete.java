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
public class TestDaoAccountStatusDelete extends TestBaseDao{
    
    @Test
    void deleteEntity1() throws UnknownException {
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.delete("PEN", "id");
    }

    @Test
    void deleteEntity2() throws UnknownException {
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.delete("DEL", "id");
    }

    @Test
    void deleteEntity3() throws UnknownException {
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.delete("DEA", "id");
    }

    @Test
    void deleteEntity4() throws UnknownException {
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.delete("ACT", "id");
    }    
}
