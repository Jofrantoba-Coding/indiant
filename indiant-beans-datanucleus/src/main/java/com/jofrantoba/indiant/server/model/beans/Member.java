/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.beans;

import com.mongodb.client.model.geojson.Point;
import java.util.Date;
import java.util.List;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
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
public class Member extends GlobalEntityPkLong {
    public static final String SEQUENCE="Member:_id";
    @Persistent
    private Long idColony;    
    @Persistent
    private Long idUser;   
    @Persistent
    private Point location;
    @Persistent
    private Date unionDate;    
    @Persistent
    private List<MemberInterest> memberInterest;
}
