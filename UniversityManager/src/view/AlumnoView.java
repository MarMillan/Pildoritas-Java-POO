package view;

import java.util.List;
import java.util.Scanner;

import exception.UniversidadException;
import manager.persona.AlumnoManager;
import model.asignatura.Asignatura;
import model.persona.Alumno;
import model.persona.Persona;

public class AlumnoView extends PersonaView {

	public void gestionAlumnos(Scanner scanner) throws UniversidadException {
		boolean close = false;
		while (!close) {
			mostrarMenuAlumnos();
			int choice = Integer.valueOf(scanner.nextLine());			
			switch  (choice) {
			case 1:
				listarAlumnos();
				break;
			case 2:
				addAlumno(scanner);
				break;
			case 3:
				buscarAlumno(scanner);
				break;
			case 4:
				asignarAsignatura(scanner);
				break;
			case 5:
				editarAlumno(scanner);
				break;
			case 6:
				borrarAlumno(scanner);
				break;
			case 0:
				close = true;
				break;
			}
		}	
	}
	
	private void mostrarMenuAlumnos() {
		System.out.println("|================================|");
		System.out.println("|             ALUMNOS            |");
		System.out.println("|================================|");
		System.out.println("| Opciones:                      |");
		System.out.println("|     1. Listar Alumnos          |");
		System.out.println("|     2. Añadir Alumno           |");
		System.out.println("|     3. Buscar Alumno           |");
		System.out.println("|     4. Asociar Asignaturas     |");
		System.out.println("|     5. Editar Alumno           |");
		System.out.println("|     6. Borrar Alumno           |");
		System.out.println("|     0. Salir                   |");
		System.out.println("|================================|");
	}
	
	private void listarAlumnos() {
		System.out.println("|================================|");
		System.out.println("|        LISTADO ALUMNOS         |");
		System.out.println("|================================|");
		List<Alumno> lsAlumnos = AlumnoManager.getInstance().getAlumnos();
		if (lsAlumnos.size() > 0) {
			for (Alumno alumno : lsAlumnos) 
				System.out.println(alumno.toString());	
		} else {
			System.out.println("No hay alumnos almacenados");
		}
	}
	
	private void addAlumno(Scanner scanner) throws UniversidadException {
		System.out.println("|================================|");
		System.out.println("|     INSERCCION DE ALUMNOS      |");
		System.out.println("|================================|");		
		Persona p = getPersonaData(scanner);
		Alumno alumno = new Alumno(p);
		AlumnoManager.getInstance().insertar(alumno);
	}
	
	private void buscarAlumno(Scanner scanner) throws UniversidadException {
		System.out.println("|================================|");
		System.out.println("|       BUSQUEDA DE ALUMNOS      |");
		System.out.println("|================================|");
		Alumno alumno = getAlumno(scanner);
		System.out.println(alumno.toString());
	}
	
	private void editarAlumno(Scanner scanner) throws UniversidadException {
		System.out.println("|================================|");
		System.out.println("|        EDICIÓN DE ALUMNOS      |");
		System.out.println("|================================|");	
		Alumno alumno = getAlumno(scanner);
		editPersona(scanner, alumno);
	}
	
	private Alumno getAlumno(Scanner scanner) throws UniversidadException {
		Alumno alumno = null; 
		System.out.println("Introduzca el DNI del alumno: ");
		try {
			String dni = scanner.nextLine();
			alumno = AlumnoManager.getInstance().getAlumno(dni);
		} catch (IndexOutOfBoundsException e) {
			throw new UniversidadException("Alumno no encontrado");
		}
		return alumno;
	}
	
	private void borrarAlumno(Scanner scanner) throws UniversidadException {
		Alumno alumno = getAlumno(scanner);
		System.out.println("¿De verdad quiere borrar a este alumno? (S/N)");
		String opcion = scanner.nextLine();
		if ("S".equals(opcion))
			AlumnoManager.getInstance().borrar(alumno);

	}
	
	private void asignarAsignatura(Scanner scanner) throws UniversidadException {
		System.out.println("|================================|");
		System.out.println("|       ASIGNAR ASIGNATURAS      |");
		System.out.println("|================================|");
		Alumno alumno = getAlumno(scanner);
		Asignatura asignatura = getAsignatura(scanner);
		System.out.println("¿Está seguro? Y/N");
		String choice = scanner.nextLine();
		if (choice.equals("Y")) {
			alumno.asignarAsignatura(asignatura);
		}
	}
}
