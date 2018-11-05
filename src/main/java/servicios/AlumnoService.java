package servicios;

import model.Alumno;

public class AlumnoService {
	
	public static Alumno obtenerAlumno(int legajo) {
        return Session.getSession().find(Alumno.class, legajo); 
	}

	public static void persistirAlumno(Alumno alu) {
		Session.beginTransaction();
		try {
			Session.getSession().persist(alu);
			Session.commitTransaction();
		}catch(Exception e) {
			Session.rollbackTransaction();
		}		
	}
	
}
