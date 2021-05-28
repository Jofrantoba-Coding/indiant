/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.beans;

import com.jofrantoba.indiant.server.shared.beans.InterEntity;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author jona
 */
@Log4j2
@Data
@PersistenceCapable(detachable="true")
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class GlobalEntityPkString implements InterEntity{
    @PrimaryKey
    @Persistent  
    private String id;
    @Persistent          
    private Long version;    
    @Persistent       
    private Boolean isPersistente;
    @NotPersistent        
    private String operacion;
}
