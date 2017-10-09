package model.persona;

/**
 * Clase Profesor
 * @author mar.millan
 * @version 2.0
 * @since 2014
 */
public class Profesor extends Persona {
	private String codProfesor;
	
	public Profesor (String codProfesor, String nombre, String apellidos, String dni, Integer edad, String sexo) {
		super(nombre, apellidos, dni, edad, sexo);
		this.codProfesor = codProfesor;
	}
	
	public Profesor(Persona p) {
		super(p.getNombre(), p.getApellidos(), p.getDni(), p.getEdad(), p.getSexo());
	}
	
	public void setCodProfesor(String codProfesor) {
		this.codProfesor = codProfesor;
	}

	public String getCodProfesor() {
		return codProfesor;
	}
	
	@Override
	public String toString() {
        String nuevalinea = System.getProperty("line.separator");
        return "Código Profesor: " + this.getCodProfesor() + nuevalinea + super.toString();
    }
}
