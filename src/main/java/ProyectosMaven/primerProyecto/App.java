package ProyectosMaven.primerProyecto;

import java.sql.Connection;

import javax.management.Query;

import Consultas.Querys;
import Util.variablesConexionSQL;
import modelo.conexionPostgreSQL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Constantes
    	final String HOST = variablesConexionSQL.getHost();
    	final String PORT = variablesConexionSQL.getPort();
    	final String DB = variablesConexionSQL.getDb();
    	final String USER = variablesConexionSQL.getUser();
    	final String PASS = variablesConexionSQL.getPass();
    	
    	//Conexion
    	conexionPostgreSQL conexionPostgresql = new conexionPostgreSQL();
    	Connection conexionGenerada = conexionPostgresql.generaConexion(HOST,PORT,DB,USER,PASS);
    	
    	
    	System.out.println("CONTEO DE ALUMNOS/ASIGNATURAS");
    	//Querys Select
    	Querys.SelectAlumnos("alumnos", conexionGenerada);
    	Querys.SelectAsignaturas("asignaturas", conexionGenerada);
    	
    	System.out.println("INSERT DE ALUMNOS/ASIGNATURAS");
    	//Querys Insert
    	Querys.InsertAlumnos("alumnos", conexionGenerada);
    	Querys.InsertAsignaturas("asignaturas",conexionGenerada);
    	
    	System.out.println("DELETE DE ALUMNOS/ASIGNATURAS");
    	//Querys Delete
    	Querys.DeleteAlumnos("alumnos", conexionGenerada, 1);
    	Querys.DeleteAsignaturas("asignaturas", conexionGenerada, 1);
    	
    	System.out.println("CONTEO DE ALUMNOS/ASIGNATURAS");
    	//Querys Select
    	Querys.SelectAlumnos("alumnos", conexionGenerada);
    	Querys.SelectAsignaturas("asignaturas", conexionGenerada);
    	
    	System.out.println("INSERT DE ALUMNOS/ASIGNATURAS");
    	Querys.UpdateAlumnos("alumnos", conexionGenerada, "Julio", 9);
    	Querys.UpdateAsignaturas("asignaturas", conexionGenerada, "Lengua", 9);
    	
    	//Querys Create Table
    	System.out.println("CREACION DE TABLA");
    	Querys.createTable("prueba2", conexionGenerada);
    	
    	
    	System.out.println("INSERT DE RELACION ALUMNOS/ASIGNATURAS");
    	//Querys Insert
    	Querys.InsertRelacion(conexionGenerada);
    	System.out.println("CONTEO DE RELACIONES ALUMNOS/ASIGNATURAS");
    	//Querys Select
    	Querys.SelectRelaciones( conexionGenerada);

    }
}
