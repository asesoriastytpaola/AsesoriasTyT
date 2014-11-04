/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;

import co.poli.asesoriastyt.dao.DAOPerfiles;
import co.poli.asesoriastyt.model.Perfil;
import co.poli.asesoriastyt.util.Conexion;

/**
 * @author natad_000
 *
 */
public class NPerfiles {

	/**
	 * 
	 */
	DAOPerfiles daoPerfiles;
	Connection c;

	public int Crear(Perfil Perfiles) {
		daoPerfiles = new DAOPerfiles();
		new Conexion();
		c = Conexion.getConnection();
		int resultadoCrear = daoPerfiles.Crear(c, Perfiles);
		return resultadoCrear;
	}

}
