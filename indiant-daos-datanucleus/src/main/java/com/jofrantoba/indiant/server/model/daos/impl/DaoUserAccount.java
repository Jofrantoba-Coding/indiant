/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.UserAccount;
import com.jofrantoba.model.jdo.daoentity.AbstractMongoJdoDao;
import com.jofrantoba.model.jdo.pmf.PMF;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoUserAccount;

/**
 *
 * @author jona
 */
public class DaoUserAccount extends AbstractMongoJdoDao<UserAccount> 
        implements InterDaoUserAccount{
    
    public DaoUserAccount(){
        super();
        setClazz(UserAccount.class);
        this.setPmf(PMF.getClassPMF().getPMFStatic());
    }
    
}
