package model.persona;
/**
 * Clase Test para probar la clase Persona
 * @author mar.millan
 * @version 1.0
 * @since 2014
 */
public class PruebaPersona {
	 
    public static void main(String[] args) {        
        Persona mar = new Persona();
               
        mar.setNombre("Mar");
        mar.setApellidos("Millan");
        mar.setEdad(27);
        mar.setSexo("F");
        mar.setDni("01168899Q");
         
        System.out.println(mar.toString());     
    }
}