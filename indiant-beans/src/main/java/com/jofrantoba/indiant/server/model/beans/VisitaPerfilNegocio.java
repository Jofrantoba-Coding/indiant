package com.jofrantoba.indiant.server.model.beans;


import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;



@PersistenceCapable(detachable="true")
public class VisitaPerfilNegocio implements InterEntity{
	
	private static final long serialVersionUID = -5724065956748449114L;
	@PrimaryKey
	@Persistent
	
	private String idVisitaPerfil;
	@Persistent
	
	private UsuarioTurista beanUsuarioTurista;
	@Persistent
	
	private UsuarioNegocio beanUsuarioNegocio;
	@Persistent
	private Date fecha;
	@Persistent
	private Long version;
	@NotPersistent
	private String operacion;
	
	public String getIdVisitaPerfil() {
		return idVisitaPerfil;
	}
	public void setIdVisitaPerfil(String idVisitaPerfil) {
		this.idVisitaPerfil = idVisitaPerfil;
	}
	public UsuarioTurista getBeanUsuarioTurista() {
		return beanUsuarioTurista;
	}
	public void setBeanUsuarioTurista(UsuarioTurista beanUsuarioTurista) {
		this.beanUsuarioTurista = beanUsuarioTurista;
	}
	public UsuarioNegocio getBeanUsuarioNegocio() {
		return beanUsuarioNegocio;
	}
	public void setBeanUsuarioNegocio(UsuarioNegocio beanUsuarioNegocio) {
		this.beanUsuarioNegocio = beanUsuarioNegocio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beanUsuarioNegocio == null) ? 0 : beanUsuarioNegocio.hashCode());
		result = prime * result + ((beanUsuarioTurista == null) ? 0 : beanUsuarioTurista.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((idVisitaPerfil == null) ? 0 : idVisitaPerfil.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisitaPerfilNegocio other = (VisitaPerfilNegocio) obj;
		if (beanUsuarioNegocio == null) {
			if (other.beanUsuarioNegocio != null)
				return false;
		} else if (!beanUsuarioNegocio.equals(other.beanUsuarioNegocio))
			return false;
		if (beanUsuarioTurista == null) {
			if (other.beanUsuarioTurista != null)
				return false;
		} else if (!beanUsuarioTurista.equals(other.beanUsuarioTurista))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idVisitaPerfil == null) {
			if (other.idVisitaPerfil != null)
				return false;
		} else if (!idVisitaPerfil.equals(other.idVisitaPerfil))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VisitaPerfilNegocio [idVisitaPerfil=" + idVisitaPerfil + ", beanUsuarioTurista=" + beanUsuarioTurista
				+ ", beanUsuarioNegocio=" + beanUsuarioNegocio + ", fecha=" + fecha + ", version=" + version + "]";
	}		
}
