/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Privacidad;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoPrivacidad;
import com.jofrantoba.model.jdo.daoentity.AbstractJdoDao;

/**
 *
 * @author jona
 */
public class DaoPrivacidad extends AbstractJdoDao<Privacidad> 
        implements InterDaoPrivacidad{
    
    public DaoPrivacidad(){
        super();
        setClazz(Privacidad.class);
    }
    
}
