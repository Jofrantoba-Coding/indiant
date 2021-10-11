/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Sequence;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSequence;
import com.jofrantoba.model.jdo.shared.UnknownException;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoSequenceUpdate extends TestBaseDao{
    
    /*@Test
    void nextSequenceInterest() throws UnknownException {                        
        InterDaoSequence dao = contextDao.getBean(DaoSequence.class);          
        dao.getNextValueIdInterest();
    }*/
    
    @Test
    void nextSequenceUser() throws UnknownException {                        
        InterDaoSequence dao = contextDao.getBean(DaoSequence.class);          
        dao.getNextValueId("User:_id");
    }
}
