package manager.asignatura;

import java.util.ArrayList;
import java.util.List;

import model.asignatura.Asignatura;

/**
 * Clase Manager para las funcionalidades asociadas a las asignaturas
 * @author mar.millan
 * @version 1.0
 * @since 2017
 */
public class AsignaturaManager {
	
	private List<Asignatura> asignaturas = new ArrayList<Asignatura>();
	
	public static AsignaturaManager asignaturaManager;
	
	private AsignaturaManager() {
		super();
	}
	
	public static AsignaturaManager getInstance() {
		if (asignaturaManager == null)
			asignaturaManager = new AsignaturaManager();;	
		return asignaturaManager;
	}
	
	public void insertar(Asignatura asignatura) {
		this.getAsignaturas().add(asignatura);
	}
	
	public void editar(Asignatura asignatura) {
		int idx = this.getAsignaturas().indexOf(asignatura);
		asignaturas.set(idx, asignatura);
	}
	
	public void borrar(Asignatura asignatura) {
		int idx = this.getAsignaturas().indexOf(asignatura);
		this.getAsignaturas().remove(idx);
	}
	
	public List<Asignatura> getAsignaturas() {
		return this.asignaturas;
	}

	public Asignatura getAsignatura(Asignatura asignatura) {
		for (Asignatura asig : this.getAsignaturas()) {
			if (asig.equals(asignatura)) {
				return asig;
			}
		}
		return null;
	}
	
	public Asignatura getAsignatura(String nombre) {
		return getAsignatura(new Asignatura(nombre, 0, null));
	}
}
