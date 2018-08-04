package mx.com.ipb.escom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlumnoService {

	private static Map<Integer, Alumno> alumnos = new HashMap<>(); 
	
	static {
		Alumno salvador = new Alumno(102983, "Salvador", "Cruz", "Sistemas", "scg@gmail.com");
		Alumno pepe = new Alumno(102983, "Pepe", "Toro", "Admon", "pepito@gmail.com");
		
		alumnos.put(1, salvador);
		alumnos.put(2, pepe);
	}
	/**
	 * Este metodo nos regresa la lista de todos los clientes
	 * existentes en la base de datos
	 */
	@GET
	public List<Alumno> getAlumnos(){
		return new ArrayList<Alumno>(alumnos.values());
	}

/**
 * Metodo para guardar un alumno nuevo
 * 
 * @param alumno
 */
    @POST
	public void addAlumno(Alumno alumno) {
	alumnos.put(alumnos.size() + 1, alumno);
	}
    
    @DELETE
    @Path("/{alumnoId}")
    public void deleteAlumno (@PathParam ("alumnoId")int id) {
    	alumnos.remove(id);
    }
    
}
