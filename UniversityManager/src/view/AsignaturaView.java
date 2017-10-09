package view;

import java.util.List;
import java.util.Scanner;

import exception.UniversidadException;
import manager.asignatura.AsignaturaManager;
import model.asignatura.Asignatura;
import model.persona.Profesor;

public class AsignaturaView extends CommonView {
	
	public void gestionAsignaturas(Scanner scanner) throws UniversidadException {
		boolean close = false;
		while (!close) {
			mostrarMenuAsignaturas();
			int choice = Integer.valueOf(scanner.nextLine());		
			switch (choice) {
			case 1:
				listarAsignaturas();
				break;
			case 2:
				addAsignatura(scanner);
				break;
			case 3:
				buscarAsignatura(scanner);
				break;
			case 4:
				editarAsignatura(scanner);
				break;
			case 5:
				borrarAsignatura(scanner);
				break;
			case 0:
				close = true;
				break;
			}		
		}
	}
	
	private void mostrarMenuAsignaturas() {
		System.out.println("|================================|");
		System.out.println("|          ASIGNATURAS           |");
		System.out.println("|================================|");
		System.out.println("| Opciones:                      |");
		System.out.println("|     1. Listar Asignaturas      |");
		System.out.println("|     2. Añadir Asignatura       |");
		System.out.println("|     3. Buscar Asignatura       |");
		System.out.println("|     4. Editar Asignatura       |");
		System.out.println("|     5. Borrar Asignatura       |");
		System.out.println("|     0. Salir                   |");
		System.out.println("|================================|");
	}

	private void listarAsignaturas() {
		System.out.println("|================================|");
		System.out.println("|       LISTADO ASIGNATURAS      |");
		System.out.println("|================================|");	
		List<Asignatura> lsAsignaturas = AsignaturaManager.getInstance().getAsignaturas();
		if (lsAsignaturas.size() > 0) {
			for (int i = 0; i < lsAsignaturas.size(); i++) {
				Asignatura asig = lsAsignaturas.get(i);
				System.out.println(i + ". " + asig.getNombre());
			}
		} else {
			System.out.println("No hay asignaturas almacenadas");
		}
	}
	
	private void addAsignatura(Scanner scanner) throws UniversidadException {
		System.out.println("|================================|");
		System.out.println("|    INSERCCION DE ASIGNATURAS   |");
		System.out.println("|================================|");			
		System.out.println("Introduzca el nombre: ");
		String nombre = scanner.nextLine();
		System.out.println("Introduzca el curso: ");
		int curso = Integer.valueOf(scanner.nextLine());
		Profesor profesor = getProfesor(scanner);
		Asignatura asignatura = new Asignatura(nombre, curso, profesor);
		AsignaturaManager.getInstance().insertar(asignatura);
	}
	
	private void buscarAsignatura(Scanner scanner) throws UniversidadException {
		System.out.println("|================================|");
		System.out.println("|     BUSQUEDA DE ASIGNATURAS    |");
		System.out.println("|================================|");
		Asignatura asignatura = getAsignatura(scanner);
		System.out.println(asignatura.toString());
	}

	private void editarAsignatura(Scanner scanner) throws UniversidadException {
		System.out.println("|================================|");
		System.out.println("|     EDICIÓN DE ASIGNATURAS     |");
		System.out.println("|================================|");	
		Asignatura asignatura = getAsignatura(scanner);
		System.out.println("¿Quiere cambiar el nombre? (S/N)");
		String opcion = scanner.nextLine();
		if ("S".equals(opcion)) {
			System.out.println("Introduzca el nombre");
			asignatura.setNombre(scanner.nextLine());
		}
		System.out.println("¿Quiere cambiar el curso? (S/N)");
		opcion = scanner.nextLine();
		if ("S".equals(opcion)) {
			System.out.println("Introduzca el curso");
			asignatura.setCurso(Integer.valueOf(scanner.nextLine()));
		}
		System.out.println("¿Quiere cambiar al profesor? (S/N)");
		opcion = scanner.nextLine();
		if ("S".equals(opcion)) {
			Profesor profesor = getProfesor(scanner);
			asignatura.setProfesor(profesor);
		}
	}
		
	private void borrarAsignatura(Scanner scanner) throws UniversidadException {
		Asignatura asignatura = getAsignatura(scanner);
		System.out.println("¿De verdad quiere borrar esta asignatura? (S/N)");
		String opcion = scanner.nextLine();
		if ("S".equals(opcion))
			AsignaturaManager.getInstance().borrar(asignatura);
	}
	
}
