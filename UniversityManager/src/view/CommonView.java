package view;

import java.util.Scanner;

import exception.UniversidadException;
import manager.asignatura.AsignaturaManager;
import manager.persona.ProfesorManager;
import model.asignatura.Asignatura;
import model.persona.Profesor;

public abstract class CommonView {

	public Profesor getProfesor(Scanner scanner) throws UniversidadException {
		Profesor profesor = null;
		System.out.println("Introduzca el DNI del profesor: ");
		try {
			String dni = scanner.nextLine();
			profesor = ProfesorManager.getInstance().getProfesor(dni);
		} catch (IndexOutOfBoundsException e) {
			throw new UniversidadException("Profesor no encontrado");
		}
		return profesor;	
	}
	
	public Asignatura getAsignatura(Scanner scanner) throws UniversidadException {
		Asignatura asignatura = null;
		System.out.println("Introduzca el nombre de la asignatura");
		String nombre = scanner.nextLine();
		asignatura = AsignaturaManager.getInstance().getAsignatura(nombre);
		if (asignatura == null)
			throw new UniversidadException("Asignatura no encontrada");
		return asignatura;
	}
}
