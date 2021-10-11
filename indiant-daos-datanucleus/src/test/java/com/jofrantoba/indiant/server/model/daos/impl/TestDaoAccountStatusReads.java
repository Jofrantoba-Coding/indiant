/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.AccountStatus;
import com.jofrantoba.model.jdo.shared.UnknownException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
@Log4j2
public class TestDaoAccountStatusReads extends TestBaseDao{    
     
    @Test
    void readAllFields() throws UnknownException {
        DaoAccountStatus dao = new DaoAccountStatus(); 
        Collection<AccountStatus> lista=dao.allFields();
        for(AccountStatus item:lista){
            log.info("\nID:{}\nDescription:{}\nObservation:{}\nVersion:{}\nPersistent:{} ",item.get_id(),item.getDescription(),item.getObservation(),item.getVersion(),item.getIsPersistent());
        }        
    }

    @Test
    void readAllFieldsEntity() throws UnknownException {
        DaoAccountStatus dao = new DaoAccountStatus();  
        AccountStatus item=dao.allFields(false, null, 0, "PEN", "_id", false);
        log.info("\nID:{}\nDescription:{}\nObservation:{}\nVersion:{}\nPersistent:{} ",item.get_id(),item.getDescription(),item.getObservation(),item.getVersion(),item.getIsPersistent());
    }
    
    @Test
    void readAllFieldsFilter()throws UnknownException{
        DaoAccountStatus dao = new DaoAccountStatus(); 
        Map params = new HashMap();
        params.put("paramDescription", "DELETED");
        Collection<AccountStatus> lista=dao.allFields(false, null, 0, "this.description == :paramDescription", params, null);
        for(AccountStatus item:lista){
            log.info("\nID:{}\nDescription:{}\nObservation:{}\nVersion:{}\nPersistent:{} ",item.get_id(),item.getDescription(),item.getObservation(),item.getVersion(),item.getIsPersistent());
        }
    }
    
    @Test
    void readAllCustomFields()throws UnknownException{
        DaoAccountStatus dao = new DaoAccountStatus(); 
        Collection<AccountStatus> lista=dao.customField(false, null, 0, "_id,description", null, null, null);        
        for(AccountStatus item:lista){
            log.info("\nID:{}\nDescription:{}\nObservation:{}\nVersion:{}\nPersistent:{} ",item.get_id(),item.getDescription(),item.getObservation(),item.getVersion(),item.getIsPersistent());
        }
    }
    
    @Test
    void readCustomFieldsEntity()throws UnknownException{
        DaoAccountStatus dao = new DaoAccountStatus(); 
        AccountStatus item=dao.customField(false, null, 0, "_id,observation", "DEL", "_id", true);      
        log.info("\nID:{}\nDescription:{}\nObservation:{}\nVersion:{}\nPersistent:{} ",item.get_id(),item.getDescription(),item.getObservation(),item.getVersion(),item.getIsPersistent());        
    }
        
    
}
