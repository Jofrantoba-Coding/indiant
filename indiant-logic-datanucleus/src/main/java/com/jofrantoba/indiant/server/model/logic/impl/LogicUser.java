/*                                                                                                                                                                               nb/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.logic.impl;

import com.jofrantoba.indiant.server.model.beans.User;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSequence;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoUser;
import com.jofrantoba.indiant.server.model.logic.inter.InterLogicUser;
import com.jofrantoba.indiant.server.shared.enums.Status;
import com.jofrantoba.model.jdo.shared.UnknownException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Date;
import java.util.Set;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jona
 */
@Log4j2
@Component
public class LogicUser extends LogicBase implements InterLogicUser{ 
    
    @Autowired    
    private InterDaoUser daoUser;
    
    @Autowired    
    private InterDaoSequence daoSequence;
    
    @Autowired
    private Validator validator;
    
    @Override
    public void createUserOauth(User entity)throws UnknownException {
        Long idUser=daoSequence.getNextValueId(User.SEQUENCE);
        Date currentDate=new Date();
        entity.set_id(idUser);
        entity.setVersion(currentDate.getTime());
        entity.setStatus(Status.ACT.name());
        entity.setIsPersistent(Boolean.TRUE);
        entity.setCreationDate(currentDate);
        Set<ConstraintViolation<User>> constraintViolations = validator.validate( entity );
        if(constraintViolations.isEmpty()){
            daoUser.saveOrUpdate(entity);        
        }else{
            log.error(constraintViolations.toString());
        }
    }
        
}
