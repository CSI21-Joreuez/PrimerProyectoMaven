package DTOs;

public class rel_asig_alumDTO {

	int id_alumno;
	int id_asignatura;
	
	public rel_asig_alumDTO(int id_alumno, int id_asignatura) {
		super();
		this.id_alumno = id_alumno;
		this.id_asignatura = id_asignatura;
	}
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	public int getId_asignatura() {
		return id_asignatura;
	}
	public void setId_asignatura(int id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	
}
