/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.beans;

import com.mongodb.client.model.geojson.Point;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author jona
 */
@Component
@Scope("prototype")
@EqualsAndHashCode(callSuper = false)
@Data
@Log4j2
@PersistenceCapable(detachable = "true")
public class User extends GlobalEntityPkLong { 
    public static final String SEQUENCE="User:_id";
    @NotNull
    @Unique    
    @Persistent
    @Email
    @NotEmpty
    private String email;    
    @Persistent
    private String password;
    @Persistent
    private String nickName;
    @Persistent
    private String name;
    @Persistent
    private String lastName;
    @Persistent
    private java.util.Date dateBirth;
    @Persistent
    private String gender;
    @Persistent
    private String Country;
    @Persistent
    private String Region;
    @Persistent
    private String place;    
    @NotNull    
    @Persistent
    private java.util.Date creationDate;        
    @Persistent
    private String profilePicture;
    @Persistent
    private String coverPhoto;
    @Persistent
    private String tokenFirebase;
    @Persistent
    private String typeRegister;
    @Persistent
    private Point locationLast;
    @Embedded(nullIndicatorColumn="accountStatus", members={
        @Persistent(name="GlobalEntityPkString._id", columns=@Column(name="id")),
        @Persistent(name="GlobalEntityPkString.version", columns=@Column(name="version")),
        @Persistent(name="GlobalEntityPkString.isPersistent", columns=@Column(name="isPersistent")),
        @Persistent(name="GlobalEntityPkString.status", columns=@Column(name="status")),
        @Persistent(name="description", columns=@Column(name="description")),
        @Persistent(name="observation", columns=@Column(name="observation"))      
    })  
    @Persistent
    private AccountStatus accountStatus;
    @Element(embeddedMapping={
         @Embedded(members={
            @Persistent(name="interest", column="interest"),
         @Persistent(name="fashionValue", column="fashionValue"),
         @Persistent(name="idUser", column="idUser")        
         })
    })
    @Join(column="idUser")
    @Persistent    
    private Collection<UserInterest> userInterest= new HashSet<UserInterest>();
}
