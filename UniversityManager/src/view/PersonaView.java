package view;

import java.util.Scanner;

import exception.UniversidadException;
import model.persona.Persona;

public abstract class PersonaView extends CommonView {

	protected void editPersona(Scanner scanner, Persona persona) {
		System.out.println("¿Quiere cambiar el nombre? (S/N)");
		String opcion = scanner.nextLine();
		if ("S".equals(opcion)) {
			System.out.println("Introduzca el nombre");
			persona.setNombre(scanner.nextLine());
		}
		System.out.println("¿Quiere cambiar el apellido? (S/N)");
		opcion = scanner.nextLine();
		if ("S".equals(opcion)) {
			System.out.println("Introduzca el apellido");
			persona.setApellidos(scanner.nextLine());
		}
		System.out.println("¿Quiere cambiar el DNI? (S/N)");
		opcion = scanner.nextLine();
		if ("S".equals(opcion)) {
			System.out.println("Introduzca el DNI");
			persona.setDni(scanner.nextLine());
		}
		System.out.println("¿Quiere cambiar la edad? (S/N)");
		opcion = scanner.nextLine();
		if ("S".equals(opcion)) {
			System.out.println("Introduzca la edad");
			persona.setEdad(Integer.valueOf(scanner.nextLine()));
		}
		System.out.println("Quiere cambiar el sexo? (S/N)");
		opcion = scanner.nextLine();
		if ("S".equals(opcion)) {
			System.out.println("Introduzca el sexo");
			persona.setSexo(scanner.nextLine());
		}
	}
	
	protected Persona getPersonaData(Scanner scanner) throws UniversidadException {
		System.out.println("Introduzca el nombre: ");
		String nombre = scanner.nextLine();
		System.out.println("Introduzca los apellidos: ");
		String apellidos = scanner.nextLine();
		System.out.println("Introduzca el DNI: ");
		String dni = scanner.nextLine();
		System.out.println("Introduzca el sexo: ");
		String sexo = scanner.nextLine();	
		System.out.println("Introduzca la edad: ");
		int edad = -1;
		try {
			edad = Integer.valueOf(scanner.nextLine());	
			if (edad < 0) {
				throw new UniversidadException("La edad tiene que ser positiva");
			}
		} catch (NumberFormatException e) {
			throw new UniversidadException("Tiene que introducir caracteres numéricos en la edad");
		}
		
		return new Persona(nombre, apellidos, dni, edad, sexo);
	}
}
