/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.CuentaTurista;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoCuentaTurista;
import com.jofrantoba.model.jdo.daoentity.AbstractJdoDao;

/**
 *
 * @author jona
 */
public class DaoCuentaTurista extends AbstractJdoDao<CuentaTurista> 
        implements InterDaoCuentaTurista{
    
    public DaoCuentaTurista(){
        super();
        setClazz(CuentaTurista.class);
    }
    
}
