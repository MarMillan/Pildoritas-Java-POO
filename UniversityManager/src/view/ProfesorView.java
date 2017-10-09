package view;

import java.util.List;
import java.util.Scanner;

import exception.UniversidadException;
import manager.persona.ProfesorManager;
import model.persona.Persona;
import model.persona.Profesor;

public class ProfesorView extends PersonaView {

	public void gestionProfesores(Scanner scanner) throws UniversidadException {		
		boolean close = false;
		while (!close) {
			mostrarMenuProfesores();
			int choice = Integer.valueOf(scanner.nextLine());		
			switch  (choice) {
			case 1: 
				listarProfesores();
				break;
			case 2:
				addProfesor(scanner);
				break;
			case 3:
				buscarProfesor(scanner);
				break;
			case 4:
				editarProfesor(scanner);
				break;
			case 5:
				borrarProfesor(scanner);
				break;
			case 0:
				close = true;
				break;
			}
		}
	}
	
	private void mostrarMenuProfesores() {
		System.out.println("|================================|");
		System.out.println("|            PROFESORES          |");
		System.out.println("|================================|");
		System.out.println("| Opciones:                      |");
		System.out.println("|     1. Listar Profesores       |");
		System.out.println("|     2. Añadir Profesor         |");
		System.out.println("|     3. Buscar Profesor         |");
		System.out.println("|     4. Editar Profesor         |");
		System.out.println("|     5. Borrar Profesor         |");
		System.out.println("|     0. Salir                   |");
		System.out.println("|================================|");
	}
	
	private void listarProfesores() {
		System.out.println("|================================|");
		System.out.println("|       LISTADO PROFESORES       |");
		System.out.println("|================================|");
		List<Profesor> lsProfesores = ProfesorManager.getInstance().getProfesores();
		if (lsProfesores.size() > 0) {
			for (Profesor profesor : lsProfesores)
				System.out.println(profesor.toString());
		} else 
			System.out.println("No hay profesores almacenados");
	}
	
	private void addProfesor(Scanner scanner) throws UniversidadException {
		System.out.println("|================================|");
		System.out.println("|    INSERCCION DE PROFESORES    |");
		System.out.println("|================================|");		
		Persona p = getPersonaData(scanner);
		Profesor profesor = new Profesor(p);
		ProfesorManager.getInstance().insertar(profesor);
	}
	
	private void editarProfesor(Scanner scanner) throws UniversidadException {
		System.out.println("|================================|");
		System.out.println("|      EDICIÓN DE PROFESORES     |");
		System.out.println("|================================|");	
		Profesor profesor = getProfesor(scanner);
		editPersona(scanner, profesor);
	}
	
	private void borrarProfesor(Scanner scanner) throws UniversidadException {
		Profesor profesor = getProfesor(scanner);
		System.out.println("¿De verdad quiere borrar a este profesor? (S/N)");
		String opcion = scanner.nextLine();
		if ("S".equals(opcion))
			ProfesorManager.getInstance().borrar(profesor);
	}
	
	private void buscarProfesor(Scanner scanner) throws UniversidadException {
		System.out.println("|================================|");
		System.out.println("|     BUSQUEDA DE PROFESORES     |");
		System.out.println("|================================|");
		Profesor profesor = getProfesor(scanner);
		System.out.println(profesor.toString());
	}
	
	
}
