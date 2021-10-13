/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Interest;
import com.jofrantoba.model.jdo.shared.UnknownException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
@Log4j2
public class TestDaoInterestReads extends TestBaseDao{    

    @Test
    void readEntity1() throws UnknownException {
        DaoInterest dao = new DaoInterest();
        Interest item=dao.customField(false, null, 0, "_id,description", 5l,"_id");
        log.info("\nID:{}\nDescription:{}\nVersion:{}\nPersistent:{} ",item.get_id(),item.getDescription(),item.getVersion(),item.getIsPersistent());
    }
   
}
