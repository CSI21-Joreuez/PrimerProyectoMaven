package Consultas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTOs.AlumnosDTO;
import DTOs.AsignaturaDTO;
import DTOs.dtoAlumnosDTO;
import DTOs.dtoAsignaturasDTO;
import DTOs.dtoRel_asig_alumDTO;

public class Querys {

	
	public static void SelectAlumnos (String tabla, Connection conexion)
	{
		Statement declaracionSQL;
		ResultSet resultadoConsulta;
		try {
			declaracionSQL = conexion.createStatement();
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"proyectoMaven\".\""+tabla+"\"");
			dtoAlumnosDTO.resultsetAdtoAlumno(resultadoConsulta);
			
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-Select] Cierre declaración y resultado");				
		    resultadoConsulta.close();
		    declaracionSQL.close();
		    
		} catch (SQLException e) {
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL Select Alumno: " + e);
		}
	}
	public static void SelectAsignaturas (String tabla, Connection conexion)
	{
		Statement declaracionSQL;
		ResultSet resultadoConsulta;
		try {
			declaracionSQL = conexion.createStatement();
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"proyectoMaven\".\""+tabla+"\"");
			 dtoAsignaturasDTO.resultsetAdtoAsignatura(resultadoConsulta);			
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-Select] Cierre declaración y resultado");				
		    resultadoConsulta.close();
		    declaracionSQL.close();
		    
		} catch (SQLException e) {
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL Select Asignatura: " + e);
		}
	}
	public static void SelectRelaciones ( Connection conexion)
	{
		Statement declaracionSQL;
		ResultSet resultadoConsulta;
		try {
			declaracionSQL = conexion.createStatement();
			resultadoConsulta = declaracionSQL.executeQuery("SELECT a.id_alumnos, rel.asignatura_id FROM \"proyectoMaven\".alumnos as a JOIN \"proyectoMaven\".rel_asig_alumn as rel ON(a.id_alumnos = rel.alumno_id);");
			dtoRel_asig_alumDTO.resultsetArel_asig_alumn(resultadoConsulta);
			
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-Select] Cierre declaración y resultado");				
		    resultadoConsulta.close();
		    declaracionSQL.close();
		    
		} catch (SQLException e) {
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL Select Relacion: " + e);
		}
	}
	
	public static void InsertAlumnos(String tabla, Connection conexion)
	{
		
		Statement declaracionSQL;
		try {
			declaracionSQL = conexion.createStatement();
			declaracionSQL.executeUpdate("INSERT INTO \"proyectoMaven\"."+tabla+" (nombre,apellidos,email) VALUES ('Juan Carlos', 'Orea Rodriguez', 'jc@gmail.com')");
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-Insert] Cierre declaración y resultado");				
		    declaracionSQL.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL InsertAlumnos: " + e);

		}
	}
	public static void InsertAsignaturas(String tabla, Connection conexion)
	{
		
		Statement declaracionSQL;
		try {
			declaracionSQL = conexion.createStatement();
			declaracionSQL.executeUpdate("INSERT INTO \"proyectoMaven\"."+tabla+" (nombre,descripcion,alias) VALUES ('Matematicas', 'Asignatura De Matematicas', 'MATES')");
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-Insert] Cierre declaración y resultado");				
		    declaracionSQL.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL InsertAsignaturas: " + e);

		}
	}
	public static void InsertRelacion( Connection conexion)
	{
		
		Statement declaracionSQL;
		try {
			declaracionSQL = conexion.createStatement();
			declaracionSQL.executeUpdate("INSERT INTO \"proyectoMaven\".rel_asig_alumn (alumno_id,asignatura_id) VALUES (29,20)");
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-Insert] Cierre declaración y resultado");				
		    declaracionSQL.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL InsertRelacion: " + e);

		}
	}
	public static void DeleteAlumnos(String tabla, Connection conexion, int id)
	{
		Statement declaracionSQL;
		try {
			declaracionSQL = conexion.createStatement();
			declaracionSQL.executeUpdate("DELETE FROM \"proyectoMaven\"."+tabla+" WHERE id_alumnos = "+id+"");
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-Delete] Cierre  declaración y resultado");				
		    declaracionSQL.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL DeleteAlumnos: " + e);
		}
	}
	
	public static void DeleteAsignaturas(String tabla, Connection conexion, int id)
	{
		Statement declaracionSQL;
		try {
			declaracionSQL = conexion.createStatement();
			declaracionSQL.executeUpdate("DELETE FROM \"proyectoMaven\"."+tabla+" WHERE id_asignatura = "+id+"");
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-Delete] Cierre declaración y resultado");				
		    declaracionSQL.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL DeleteAsignaturas: " + e);
		}
	}
	public static void UpdateAlumnos(String tabla, Connection conexion, String nombre, int id)
	{
		Statement declaracionSQL;
		try {
			declaracionSQL = conexion.createStatement();
			declaracionSQL.executeUpdate("UPDATE \"proyectoMaven\"."+tabla+" SET nombre='"+nombre+"' WHERE id_alumnos="+id+"");
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-Update] Cierre conexión, declaración y resultado");				
		    declaracionSQL.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL UpdateAlumnos: " + e);
		}
	}
	
	public static void UpdateAsignaturas(String tabla, Connection conexion, String nombre, int id)
	{
		Statement declaracionSQL;
		try {
			declaracionSQL = conexion.createStatement();
			declaracionSQL.executeUpdate("UPDATE \"proyectoMaven\"."+tabla+" SET nombre='"+nombre+"' WHERE id_asignatura="+id+"");
			System.out.println("[INFORMACIÓN-consultasPostgreSQL-Update] Cierre declaración y resultado");				
		    declaracionSQL.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL UpdateAsignatura: " + e);
		}
	}
	
	public static void createTable(String nombre, Connection conexion)
	{
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement("CREATE TABLE IF NOT EXISTS \"proyectoMaven\"."+nombre+"(id SERIAL NOT NULL PRIMARY KEY,usuario varchar(225),apellidos varchar(225),profesor boolean)");
			System.out.println("[INFORMACIÓN-CreacionTabla] Cierre declaración y resultado");				
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("[ERROR-CreacionTabla-main] Error generando la PreparedStatement ps: " + e);
		}
		
	}
}
