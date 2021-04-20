/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.EstadoMiembro;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoEstadoMiembro;
import com.jofrantoba.model.jdo.daoentity.AbstractJdoDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jona
 */
@Log4j2
@Repository
public class DaoEstadoMiembro extends AbstractJdoDao<EstadoMiembro> 
        implements InterDaoEstadoMiembro{
    
    public DaoEstadoMiembro(){
        super();
        setClazz(EstadoMiembro.class);
    }
}
