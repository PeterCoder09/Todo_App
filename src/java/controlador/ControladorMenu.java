package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorMenu", urlPatterns = {"/ControladorMenu"})
public class ControladorMenu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "inicio":
                // Si el usuario está autenticado, cargar start.jsp en el iframe
                request.getRequestDispatcher("start.jsp").forward(request, response);
                break;
            case "tareas":
                request.getRequestDispatcher("task.jsp").forward(request, response);
                break;
            case "perfil":
                request.getRequestDispatcher("profile.jsp").forward(request, response);
                break;
            case "crearTareas":
                request.getRequestDispatcher("createTask.jsp").forward(request, response);
                break;
            case "configuracion":
                request.getRequestDispatcher("setting.jsp").forward(request, response);
                break;
            case "cerrarSesion":
                // Aquí puedes manejar el cierre de sesión
                request.getSession().invalidate();
                response.sendRedirect("index.jsp");
                break;
            default:
                request.getRequestDispatcher("main.jsp").forward(request, response); // Redirigir a main.jsp por defecto
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador del menú de navegación";
    }
}
