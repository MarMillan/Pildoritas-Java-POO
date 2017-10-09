package manager.persona;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.persona.Profesor;

/**
 * Clase Manager para las funcionalidades asociadas a los profesores
 * @author mar.millan
 * @version 1.0
 * @since 2017
 */
public class ProfesorManager {
	private List<Profesor> lsProfesores = new ArrayList<Profesor>();

	private static ProfesorManager profesorManager;
	
	private ProfesorManager() {
		super();
	}
	
	public static ProfesorManager getInstance() {
		if (profesorManager == null)
			profesorManager = new ProfesorManager();
		return profesorManager;
	}
	
	public void setLsProfesores(List<Profesor> lsProfesores) {
		profesorManager.setLsProfesores(lsProfesores);
	}
	
	public void insertar(Profesor profesor) {
		String codProfesor = UUID.randomUUID().toString();
		profesor.setCodProfesor(codProfesor);
		this.getProfesores().add(profesor);
	}
	
	public void editar(Profesor profesor) {
		int idx = this.getProfesores().indexOf(profesor);
		this.getProfesores().set(idx, profesor);
	}
	
	public void borrar(Profesor profesor) {
		int idx = lsProfesores.indexOf(profesor);
		this.getProfesores().remove(idx);
	}
	
	public List<Profesor> getProfesores() {
		return this.lsProfesores;
	}
	
	public Profesor getProfesor(String dni) {
		return getProfesor(new Profesor(null, null, null, dni, null, null));
	}
	
	public Profesor getProfesor(Profesor profesor) {
		for (Profesor prof : this.getProfesores()) {
			if (prof.equals(profesor)) {
				return prof;
			}
		}
		return null;
	}

	public int numProfesores() {
		return this.getProfesores().size();
	}
}
