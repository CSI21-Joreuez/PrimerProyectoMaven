package DTOs;

public class AsignaturaDTO {

	String nombre;
	String descripcion;
	String alias;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}

	public AsignaturaDTO(String nombre, String descripcion, String alias) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.alias = alias;
	}
	
}
