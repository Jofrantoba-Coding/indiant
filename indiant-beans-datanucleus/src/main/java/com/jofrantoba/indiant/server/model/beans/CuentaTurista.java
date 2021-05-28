package com.jofrantoba.indiant.server.model.beans;


import java.util.Date;
import javax.jdo.annotations.Embedded;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@EqualsAndHashCode(callSuper=false)
@Data
@Log4j2
@PersistenceCapable(detachable = "true")
public class CuentaTurista extends GlobalEntityPkString {	
	@Persistent
	private String clave;		
	@Persistent
	private Date fechaCreacion;	
	@Persistent
	private String tipo;		
        @Embedded
	private EstadoCuenta beanEstadoCuenta;
	@Persistent
	private String codeEstadoCuenta;		
	/*@Persistent(mappedBy="beanCuentaTurista")
	private UsuarioTurista beanUsuarioTurista;*/
	@Persistent
	private String codeUsuarioTurista;	
	@Persistent
	private String tokenFirebase;	
		
}
