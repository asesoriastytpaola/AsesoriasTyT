/**
 * 
 */
package co.poli.asesoriastyt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.poli.asesoriastyt.model.Perfil;

/**
 * @author natad_000
 *
 */
public class DAOPerfiles {

	public int Crear(Connection c, Perfil Perfiles) {
		String sql = PerfilesSQL.Crear();
		int resultadoCrear = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setInt(1, Perfiles.getIdPerfil());
			st.setString(2, Perfiles.getNombrePerfil());
			resultadoCrear = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOPerfiles.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOPerfiles.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoCrear;
	}

	public int Modificar(Connection c, Perfil Perfiles) {
		String sql = PerfilesSQL.Modificar();
		int resultadoModificar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setInt(1, Perfiles.getIdPerfil());
			st.setString(2, Perfiles.getNombrePerfil());
			resultadoModificar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOPerfiles.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOPerfiles.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoModificar;
	}

}
