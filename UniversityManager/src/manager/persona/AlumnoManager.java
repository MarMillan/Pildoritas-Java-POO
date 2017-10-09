package manager.persona;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import exception.UniversidadException;
import model.persona.Alumno;

/**
 * Clase Manager para las funcionalidades asociadas a los alumnos
 * @author mar.millan
 * @version 1.0
 * @since 2017
 */
public class AlumnoManager {
	private List<Alumno> lsAlumnos = new ArrayList<Alumno>();
	
	private static AlumnoManager alumnoManager;
	
	private AlumnoManager() {
		super();
	}
	
	public static AlumnoManager getInstance() {
		if (alumnoManager == null)
			alumnoManager = new AlumnoManager();
		return alumnoManager;
	}
	
	public void insertar(Alumno alumno) {
		String codAlumno = UUID.randomUUID().toString();
		alumno.setCodAlumno(codAlumno);		
		this.getAlumnos().add(alumno);
	}
	
	public void editar(Alumno alumno) {
		int idx = this.getAlumnos().indexOf(alumno);
		this.getAlumnos().set(idx, alumno);
	}
	
	public void borrar(Alumno alumno) {
		int idx = this.getAlumnos().indexOf(alumno);
		this.getAlumnos().remove(idx);
	}

	public List<Alumno> getAlumnos() {
		return this.lsAlumnos;
	}
	
	public Alumno getAlumno(Alumno alumno) {
		for (Alumno alum : this.getAlumnos()) {
			if (alum.equals(alumno)) {
				return alum;
			}
		}
		return null;
	}
	
	public Alumno getAlumno(String dni) { 
		return getAlumno(new Alumno(null, null, null, dni, null, null));
	}
	
	public int numAlumnos() {
		return this.getAlumnos().size();
	}
	
	public double getNotaMediaAlumnos() throws UniversidadException {
		double resultado = 0;
		for (Alumno alum : this.getAlumnos()) {
			resultado += alum.getNotaMedia();
		}
		return (resultado != 0 ? resultado / this.getAlumnos().size(): 0);
	}
}
