/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.logic;

import com.jofrantoba.indiant.server.model.beans.User;
import com.jofrantoba.indiant.server.model.daos.impl.DaoSequence;
import com.jofrantoba.indiant.server.model.daos.inter.InterDaoSequence;
import com.jofrantoba.indiant.server.model.logic.impl.LogicUser;
import com.jofrantoba.indiant.server.model.logic.inter.InterLogicUser;
import com.jofrantoba.model.jdo.shared.UnknownException;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestLogicUser extends TestBaseLogic{
    
    @Test
    void createEntity1()throws UnknownException {
       InterLogicUser logic=contextLogic.getBean(LogicUser.class);
       User entity = contextEntity.getBean(User.class);                     
       entity.setEmail("tyuiop302@gmail.com");
       logic.createUserOauth(entity);
    }
}
