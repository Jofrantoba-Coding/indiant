/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.EstadoCuenta;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoEstadoCuenta;
import com.jofrantoba.model.jdo.daoentity.AbstractJdoDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jona
 */
@Log4j2
@Repository
public class DaoEstadoCuenta extends AbstractJdoDao<EstadoCuenta> 
        implements InterDaoEstadoCuenta{
    
    public DaoEstadoCuenta(){
        super();
        setClazz(EstadoCuenta.class);
    }
    
}
