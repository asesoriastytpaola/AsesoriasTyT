package co.poli.asesoriastyt.control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import co.poli.asesoriastyt.model.Perfil;
import co.poli.asesoriastyt.negocio.NPerfiles;
import co.poli.asesoriastyt.util.Conexion;

/**
 * Servlet implementation class Perfiles
 */
@WebServlet(description = "Controlador de maestro perfiles", urlPatterns = { "/Perfiles" })
public class Perfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Perfil Perfiles = new Perfil();
        Perfiles.setIdPerfil(Integer.parseInt(request.getParameter("IdPerfil")));
        Perfiles.setNombrePerfil(request.getParameter("NombrePerfil"));
        String id = request.getParameter("IdPerfil");
        String nom = request.getParameter("NombrePerfil");
        
		if ("Crear".equals(request.getParameter("action"))) {

            try {
                ResultSet r = Conexion.getConnection().prepareStatement("Select Id_Perfil from perfiles").executeQuery();
                while (r.next()) {
                    if (id.equals(r.getString(1))) {
                        JOptionPane.showMessageDialog(null, "Este registro ya existe, por favor verifique la identificación del perfil", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
                        request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
                    }
                }
            } catch (SQLException e) {
            	e.printStackTrace();
            }

            if (id.equals("") && nom.equals("")) {
                JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
            } else if (id.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la identificaci�n del perfil.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
            } else if (nom.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del perfil.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
            } else {
                int resultado = new NPerfiles().Crear(Perfiles);
                try {
                    response.sendRedirect("Perfiles.jsp");
                    JOptionPane.showMessageDialog(null, "Se guard� correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
                    request.setAttribute("cli", resultado);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
	}

}
