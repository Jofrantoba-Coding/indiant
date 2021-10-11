/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.model.jdo.shared.UnknownException;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoInterestDelete extends TestBaseDao{    

    @Test
    void deleteEntity1() throws UnknownException {
        DaoInterest dao = new DaoInterest();
        dao.delete(1, "_id");
    }

    @Test
    void deleteEntity2() throws UnknownException {
        DaoInterest dao = new DaoInterest();
        dao.delete(2, "_id");
    }

    @Test
    void deleteEntity3() throws UnknownException {
        DaoInterest dao = new DaoInterest();
        dao.delete(3, "_id");
    }

    @Test
    void deleteEntity4() throws UnknownException {
        DaoInterest dao = new DaoInterest();
        dao.delete(4, "_id");
    }
}
