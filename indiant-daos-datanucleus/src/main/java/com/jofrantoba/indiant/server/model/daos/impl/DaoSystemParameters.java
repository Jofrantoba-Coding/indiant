/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.impl;

import com.jofrantoba.indiant.server.model.beans.SystemParameters;
import com.jofrantoba.model.jdo.daoentity.AbstractMongoJdoDao;
import com.jofrantoba.model.jdo.pmf.PMF;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSystemParameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jona
 */
@Log4j2
@Repository
public class DaoSystemParameters extends AbstractMongoJdoDao<SystemParameters> 
        implements InterDaoSystemParameters{
    
    public DaoSystemParameters(){
        super();
        setClazz(SystemParameters.class);
        this.setPmf(PMF.getClassPMF().getPMFStatic());
    }
    
}
