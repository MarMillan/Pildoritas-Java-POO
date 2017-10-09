package model.persona;

import java.util.ArrayList;
import java.util.List;

import exception.UniversidadException;
import model.asignatura.Asignatura;

/**
 * Clase Profesor
 * @author mar.millan
 * @version 2.0
 * @since 2014
 */
public class Alumno extends Persona {
	private String codAlumno;
	private List<Asignatura> asignaturas;
	
	public Alumno (String codAlumno, String nombre, String apellidos, String dni, Integer edad, String sexo) {
		super(nombre, apellidos, dni, edad, sexo);
		this.codAlumno = codAlumno;
		this.asignaturas = new ArrayList<Asignatura>();
	}
	
	public Alumno (Persona p) {
		super(p.getNombre(), p.getApellidos(), p.getDni(), p.getEdad(), p.getSexo());
	}
	
	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}
	public String getCodAlumno() {
		return codAlumno;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	
	public void asignarAsignatura(Asignatura asignatura) {
		asignaturas.add(asignatura);
	}

	public double getNotaMedia() throws UniversidadException {
		double resultado = 0;
		
		if (asignaturas == null || asignaturas.size() == 0) {
			throw new UniversidadException("El alumno no puede estar matriculado a 0 asignaturas");
		} else {
			for (Asignatura asig: asignaturas) 
				resultado += asig.getNota();
		}
		return (resultado != 0 ? resultado / asignaturas.size(): 0);
	}
	
	@Override
	public String toString() {
        String nuevalinea = System.getProperty("line.separator");
        return "Código Alumno: " + this.getCodAlumno() + nuevalinea + super.toString();
    }
}
