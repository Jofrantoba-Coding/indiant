/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.Privacy;
import com.jofrantoba.model.jdo.daoentity.AbstractMongoJdoDao;
import com.jofrantoba.model.jdo.pmf.PMF;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoPrivacy;

/**
 *
 * @author jona
 */
public class DaoPrivacy extends AbstractMongoJdoDao<Privacy> 
        implements InterDaoPrivacy{
    
    public DaoPrivacy(){
        super();
        setClazz(Privacy.class);
        this.setPmf(PMF.getClassPMF().getPMFStatic());
    }
    
}
