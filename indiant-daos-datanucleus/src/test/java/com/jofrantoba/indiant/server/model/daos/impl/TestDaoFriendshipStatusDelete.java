/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.model.jdo.shared.UnknownException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
@Log4j2
public class TestDaoFriendshipStatusDelete extends TestBaseDao{    
     
    @Test
    void deleteEntity1() throws UnknownException {
        DaoFriendshipStatus dao = new DaoFriendshipStatus();
        dao.delete("DEL", "id");
    }

    @Test
    void deleteEntity2() throws UnknownException {
        DaoFriendshipStatus dao = new DaoFriendshipStatus();
        dao.delete("LOC", "id");
    }

    @Test
    void deleteEntity3() throws UnknownException {
        DaoFriendshipStatus dao = new DaoFriendshipStatus();
        dao.delete("ACT", "id");
    }    
}
