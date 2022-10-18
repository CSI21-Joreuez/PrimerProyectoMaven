package DTOs;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dtoAlumnosDTO {
public static ArrayList<AlumnosDTO> resultsetAdtoAlumno(ResultSet resultadoConsulta){
		
		System.out.println("[INFORMACIÓN-resultsetAdtoAlumno-resultsetAdtoAlumno] Entrando en resultsetAdtoAlumno");
		ArrayList<AlumnosDTO> listAlumnos = new ArrayList<AlumnosDTO>();
		
		//Leemos el resultado de la consulta hasta que no queden filas
		try {
			while ( resultadoConsulta.next() ) {
				
				listAlumnos.add(new AlumnosDTO(resultadoConsulta.getString("nombre"),
						resultadoConsulta.getString("apellidos"),
						resultadoConsulta.getString("email"))
						);
			}
			
			int i = listAlumnos.size();
			System.out.println("[INFORMACIÓN-resultsetAdtoAlumno-resultsetAdtoAlumno] Número alumnos: "+i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listAlumnos;
}
}
