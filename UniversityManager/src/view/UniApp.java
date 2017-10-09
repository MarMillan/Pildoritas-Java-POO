package view;

import java.util.Scanner;

public class UniApp {
	
	public AlumnoView alumnoView = new AlumnoView();
	public ProfesorView profesorView = new ProfesorView();
	public AsignaturaView asignaturaView = new AsignaturaView();
	
	public void lanzarAplicacion() {
		boolean close = false;
		Scanner scanner = new Scanner(System.in);
		try {
			while (!close) {
				mostrarMenuPrincipal();		
				int choice = Integer.valueOf(scanner.nextLine());			
				switch  (choice) {
				case 1:
					alumnoView.gestionAlumnos(scanner);
					break;
				case 2:
					profesorView.gestionProfesores(scanner);
					break;
				case 3:
					asignaturaView.gestionAsignaturas(scanner);
					break;
				case 0:
					close = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private void mostrarMenuPrincipal() {
		System.out.println("|================================|");
		System.out.println("|       MENU DE SELECCION        |");
		System.out.println("|================================|");
		System.out.println("| Opciones:                      |");
		System.out.println("|     1. Gesti�n de Alumnos      |");
		System.out.println("|     2. Gesti�n de Profesores   |");
		System.out.println("|     3. Gesti�n de Asignaturas  |");
		System.out.println("|     0. Salir                   |");
		System.out.println("|================================|");
	}

}
