/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.AccountStatus;
import com.jofrantoba.model.jdo.shared.UnknownException;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoAccountStatusUpdate extends TestBaseDao{    


    @Test
    void updateEntity1() throws UnknownException {
        DaoAccountStatus dao = new DaoAccountStatus();
        AccountStatus entity = dao.find(null, 1, "PEN");
        entity.setDescription("PENDIENTE");
        entity.setObservation("PENDIENTE DE ACTIVACION(PRIMER ESTADO DE CUENTA)");
        entity.setVersion(5L);          
        dao.saveOrUpdate(entity);
    }   
    @Test
    void updateEntity2() throws UnknownException {                
        DaoAccountStatus dao = new DaoAccountStatus();
        AccountStatus entity=dao.find(null, 1, "DEA");
        entity.setDescription("DESACTIVADO");
        entity.setObservation("USUARIO DESACTIVA SU CUENTA TEMPORALMENTE Y PUEDE VOLVER A ACTIVARLA");
        entity.setVersion(6L);        
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void updateEntity3() throws UnknownException {                
        DaoAccountStatus dao = new DaoAccountStatus();
        AccountStatus entity=dao.find(null, 1, "DEL");
        entity.setDescription("ELIMINADO");
        entity.setObservation("USUARIO ELIMINA SU CUENTA");
        entity.setVersion(7L);
        dao.saveOrUpdate(entity);
    }
    
    @Test
    void updateEntity4() throws UnknownException {                
        DaoAccountStatus dao = new DaoAccountStatus();
        AccountStatus entity=dao.find(null, 1, "ACT");
        entity.setDescription("ACTIVADO");
        entity.setObservation("SE PUEDE PASAR DESDE LOS ESTADOS: PENDIENTE Y DESACTIVADO");
        entity.setVersion(7L);        
        dao.saveOrUpdate(entity);
    }
    
    /*@Test
    void updateEntity5() throws UnknownException {                
        DaoAccountStatus dao = new DaoAccountStatus();
        dao.updateBulk("isPersistent=:1,description=:2,observation:2", "id == :3",new Object[]{true,"Otra descripcion","DEL"});
    }*/
}
