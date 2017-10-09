package model.persona;

/**
 * Clase Persona
 * @author mar.millan
 * @version 1.0
 * @since 2014
 */
public class Persona {
	 
    private String nombre;
    private String apellidos;
    private String dni;
    private Integer edad;
    private String sexo;
    
    Persona() {
    	super();
    }
    
    public Persona(String nombre, String apellidos, String dni, Integer edad, String sexo) {
    	super();
    	this.nombre = nombre;
    	this.apellidos = apellidos;
    	this.dni = dni;
    	this.edad = edad;
    	this.sexo = sexo;
    }
    
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getApellidos() {
        return apellidos;
    }
 
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
 
    public String getDni() {
        return dni;
    }
 
    public void setDni(String dni) {
        this.dni = dni;
    }
 
    public Integer getEdad() {
        return edad;
    }
 
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
 
    public String getSexo() {
        return sexo;
    }
 
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
     
    @Override
    public String toString() {
        String nuevalinea = System.getProperty("line.separator");
        String resultado = 
                "Nombre: " + this.getNombre() + nuevalinea + 
                "Apellidos: " + this.getApellidos() + nuevalinea + 
                "DNI: " + this.getDni() + nuevalinea +
                "Edad: " + this.getEdad() + nuevalinea +
                "Sexo: " + this.getSexo() + nuevalinea;
        return resultado;
    }
    
	@Override
	public boolean equals(Object object) {
		final Persona aux = (Persona) object;
		if (this == object)
	           return true;
		else if (object == null)
	           return false;
		else if (getClass() != object.getClass())
	           return false;
		else if (this.dni.equals(aux.getDni())) {
			return true;
		} else {
			return false;
		}
	}
}