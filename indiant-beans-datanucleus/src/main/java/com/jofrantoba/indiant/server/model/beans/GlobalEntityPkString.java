/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.beans;

import com.jofrantoba.indiant.server.shared.beans.InterEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class GlobalEntityPkString implements InterEntity{
    @NotNull    
    @NotEmpty
    @PrimaryKey
    @Persistent  
    private String _id;
    @NotNull    
    @Persistent          
    private Long version; 
    @NotNull    
    @NotEmpty
    @Persistent
    private String status;//DEL:Deleted,ACT:Activaded:DEA:Deactivated
    @NotNull    
    @Persistent       
    private Boolean isPersistent;
    @NotPersistent        
    private String dmlOperation;
}
