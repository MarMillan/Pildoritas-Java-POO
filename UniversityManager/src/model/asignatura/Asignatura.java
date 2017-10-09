package model.asignatura;

import model.persona.Profesor;

/**
 * Clase Asignatura
 * @author marmillan
 * @version 2.0
 * @since 2014
 */
public class Asignatura {
	private String nombre;
	private int curso;
	private Profesor profesor;
	private double nota = 0;
	
	public Asignatura(String nombre, int curso, Profesor profesor) {
		super();
		this.nombre = nombre;
		this.curso = curso;
		this.profesor = profesor;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
        String nuevalinea = System.getProperty("line.separator");
        String resultado = 
                "Nombre: " + this.getNombre() + nuevalinea + 
                "Curso: " + this.getCurso() + nuevalinea + 
                "Profesor: " + this.getProfesor() + nuevalinea +
                "Nota: " + this.getNota() + nuevalinea;     
        return resultado;
    }
	
	@Override
	public boolean equals(Object object) {
		final Asignatura aux = (Asignatura) object;
		if (this == object)
	           return true;
		else if (object == null)
	           return false;
		else if (getClass() != object.getClass())
	           return false;
		else if (this.nombre.equals(aux.getNombre())) {
			return true;
		} else {
			return false;
		}
	}
}
