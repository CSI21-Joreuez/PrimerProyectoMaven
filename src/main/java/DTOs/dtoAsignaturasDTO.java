package DTOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dtoAsignaturasDTO {
public static ArrayList<AsignaturaDTO> resultsetAdtoAsignatura(ResultSet resultadoConsulta){
		
		System.out.println("[INFORMACIÓN-resultsetAdtoAsignatura-resultsetAdtoAsignatura] Entrando en resultsetAdtoAsignatura");
		ArrayList<AsignaturaDTO> listAsignaturas = new ArrayList();
		
		//Leemos el resultado de la consulta hasta que no queden filas
		try {
			while ( resultadoConsulta.next() ) {
				
				listAsignaturas.add(new AsignaturaDTO(resultadoConsulta.getString("nombre"),
						resultadoConsulta.getString("descripcion"),
						resultadoConsulta.getString("alias"))
						);
			}
			
			int i = listAsignaturas.size();
			System.out.println("[INFORMACIÓN-resultsetAdtoAsignatura-resultsetAdtoAsignatura] Número asignaturas: "+i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listAsignaturas;
}
}
