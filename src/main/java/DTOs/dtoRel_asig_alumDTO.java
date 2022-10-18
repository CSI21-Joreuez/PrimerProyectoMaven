package DTOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dtoRel_asig_alumDTO {

public static ArrayList<rel_asig_alumDTO> resultsetArel_asig_alumn(ResultSet resultadoConsulta){
		
		System.out.println("[INFORMACIÓN-resultsetArel_asig_alumn-resultsetAdtoAlumno] Entrando en  resultsetArel_asig_alumn");
		ArrayList<rel_asig_alumDTO> listaRelacion = new ArrayList<rel_asig_alumDTO>();
		
		//Leemos el resultado de la consulta hasta que no queden filas
		try {
			while ( resultadoConsulta.next() ) {
				
				listaRelacion.add(new rel_asig_alumDTO(resultadoConsulta.getInt("id_alumnos"),
						resultadoConsulta.getInt("asignatura_id"))						);
			}
			
			int i = listaRelacion.size();
			System.out.println("[INFORMACIÓN-resultsetAdtoAlumno-resultsetAdtoAlumno] Número relaciones: "+i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaRelacion;
}
}
