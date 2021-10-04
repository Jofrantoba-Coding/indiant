package com.jofrantoba.indiant.server.model.beans;


import java.util.ArrayList;
import java.util.Set;
import com.jofrantoba.indiant.server.shared.beans.InterEntity;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;



/**
 * La entidad UsuarioTurista almacena la informacion personal del 
 * usuario tipo turista.
 * @author Kiongo Inc SAC
 * @version 0.1
 * @since 21/05/2016
 */
@PersistenceCapable(detachable="true")
public class UsuarioTurista implements InterEntity {
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3739347446338813206L;
	
	/**
	 * idUsuarioTurista es la clave primaria para la entidad
	 * UsuarioTurista.
	 */
	@PrimaryKey	
	@Persistent
	
	private String idUsuarioTurista;
	/**
	 * codeUsuarioTurista es la clave unica que permite la generacion
	 * de la clave primaria idUsuarioTurista.
	 */
	@Persistent
	private String codeUsuarioTurista;
	@Persistent
	private String correoTurista;
	@Persistent
	private String nombre;
	@Persistent
	private String apellido;
	@Persistent
	
	private Pais beanPaisNacimiento;
	@Persistent
	private String codePaisNacimiento;
	@Persistent
	private String nombrePaisNacimiento;
	@Persistent
	
	private Region beanRegionNacimiento;
	@Persistent
	private String codeRegionNacimiento;
	@Persistent
	private String nombreRegionNacimiento;
	@Persistent
	
	private Localidad beanLocalidadNacimiento;
	@Persistent
	private String codeLocalidadNacimiento;
	@Persistent
	private String nombreLocalidadNacimiento;
	@Persistent
	private java.util.Date fechaNacimiento;
	@Persistent
	private String genero;
	@Persistent
	private String fotoPerfil;
	@Persistent
	private String fotoPortada;
	@Persistent
	private Long version;
	@NotPersistent
	private String operacion;
	@Persistent
	
	private Interes beanInteresUno;
	@Persistent
	private String nombreInteresUno;
	@Persistent
	private Double modaInteresUno;
	@Persistent
	
	private Interes beanInteresDos;
	@Persistent
	private String nombreInteresDos;
	@Persistent
	private Double modaInteresDos;
	@Persistent
	
	private Interes beanInteresTres;
	@Persistent
	private String nombreInteresTres;
	@Persistent
	private Double modaInteresTres;
	@Persistent
	private Integer totalDescubiertos;
	@Persistent
	private Integer totalConquistas;
	@Persistent
	private Integer totalColonias;
	@Persistent
	private UserAccount beanCuentaTurista;
	@Persistent
	private Boolean isPersistente;
	@Persistent
	private String estadoActivacion;
	@Persistent(mappedBy = "beanTurista") 
	private Set<TuristaInteres> listTuristaIntereses;
	@NotPersistent
	private String codeTipoNotificacion;
	@Persistent
	
	private Set<Amistad> listaAmigos;
	@Persistent
	
	private Set<Colonia> listaColonias;
	@Persistent
	
	private Set<Noticia> listNoticias;
	@Persistent
	private String tokenFirebase;
	@Persistent
	private Integer totalColoniasCreadas;
	@NotPersistent
	private Set<Colonia>listColoniasCreadas;
	@NotPersistent
	private Set<Destino>listDestinosCreados;
	@NotPersistent
	private Set<Destino>listConquistasDestinos;
	@NotPersistent
	private Set<Amistad>listAfiliados;
	@NotPersistent
	private Integer numeroAfiliados;
	@NotPersistent
	private Integer numeroConquistasDistintas;
	@Persistent
	private Integer totalNegociosCreados;
	@Persistent
	private Integer totalConquistasNegocios;
		
}
