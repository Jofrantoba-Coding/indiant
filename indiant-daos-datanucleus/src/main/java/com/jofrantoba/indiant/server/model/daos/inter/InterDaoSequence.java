/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.daos.inter;

import com.jofrantoba.indiant.server.model.beans.Sequence;
import com.jofrantoba.model.jdo.daoentity.InterMongoCrud;
import com.jofrantoba.model.jdo.shared.UnknownException;

/**
 *
 * @author jona
 */
public interface InterDaoSequence extends InterMongoCrud<Sequence>{
    Long getNextValueId(String idSequence)throws UnknownException;    
}
