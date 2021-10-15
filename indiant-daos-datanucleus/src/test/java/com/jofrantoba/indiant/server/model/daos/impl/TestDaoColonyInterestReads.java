/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.ColonyInterest;
import com.jofrantoba.indiant.server.model.beans.Interest;
import com.jofrantoba.model.jdo.shared.UnknownException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
@Log4j2
public class TestDaoColonyInterestReads extends TestBaseDao{
    
    @Test
    void readEntity1() throws UnknownException {
        DaoColonyInterest dao = new DaoColonyInterest();
        String[] members={"interest"};
        ColonyInterest item=dao.customField(true,members, 1, "_id,version,isPersistent,interest", 23l,"_id");
        log.info("\nID:{}\nVersion:{}\nPersistent:{}\nDescription:{}\nIdInterest:{}\nVersionInterest:{} ",item.get_id(),item.getVersion(),item.getIsPersistent(),item.getInterest().getDescription(),item.getInterest().get_id(),item.getInterest().getVersion());
        dao.closePm();
    }
    
    @Test
    void readEntity2() throws UnknownException {
        DaoColonyInterest dao = new DaoColonyInterest();
        ColonyInterest item=dao.find(23l);
        Interest inte=(Interest)dao.detachObject(item.getInterest());
        item=dao.detach(item);
        dao.closePm();
        log.info("\nID:{}\nVersion:{}\nPersistent:{}\nDescription:{}\nIdInterest:{}\nVersionInterest:{} ",item.get_id(),item.getVersion(),item.getIsPersistent(),item.getInterest().getDescription(),item.getInterest().get_id(),item.getInterest().getVersion());
    }
    
}
