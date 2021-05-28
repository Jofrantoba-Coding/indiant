package com.jofrantoba.indiant.server.model.beans;



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
public class ParametrosSistema extends GlobalEntityPkString {	
	@Persistent
	private String descripcion;
	@Persistent
	private String valor;
	@Persistent
	private String tipoDato;
	@Persistent
	private String unidad;
	@Persistent
	private String estado;
	
}
