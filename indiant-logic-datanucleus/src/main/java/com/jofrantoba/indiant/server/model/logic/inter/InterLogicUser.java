/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.logic.inter;

import com.jofrantoba.indiant.server.model.beans.User;
import com.jofrantoba.model.jdo.shared.UnknownException;

/**
 *
 * @author jona
 */
public interface InterLogicUser {
    void createUserOauth(User entity)throws UnknownException;  
}
