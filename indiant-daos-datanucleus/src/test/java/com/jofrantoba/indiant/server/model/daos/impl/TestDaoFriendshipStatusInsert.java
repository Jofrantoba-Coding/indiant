/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.FriendshipStatus;
import com.jofrantoba.model.jdo.shared.UnknownException;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoFriendshipStatusInsert extends TestBaseDao{        

    @Test
    void createEntity1() throws UnknownException {
        FriendshipStatus entity = new FriendshipStatus();
        entity.set_id("ACT");
        entity.setDescription("ACTIVATED");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion(1L);
        DaoFriendshipStatus dao = new DaoFriendshipStatus();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity2() throws UnknownException {
        FriendshipStatus entity = new FriendshipStatus();
        entity.set_id("DEL");
        entity.setDescription("DELETED");
        entity.setVersion(1L);
        entity.setIsPersistent(Boolean.TRUE);
        DaoFriendshipStatus dao = new DaoFriendshipStatus();
        dao.saveOrUpdate(entity);
    }

    @Test
    void createEntity3() throws UnknownException {
        FriendshipStatus entity = new FriendshipStatus();
        entity.set_id("LOC");
        entity.setDescription("LOCKED");
        entity.setIsPersistent(Boolean.TRUE);
        entity.setVersion(1L);
        DaoFriendshipStatus dao = new DaoFriendshipStatus();
        dao.saveOrUpdate(entity);
    }
}
