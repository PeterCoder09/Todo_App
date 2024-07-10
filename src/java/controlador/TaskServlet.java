package controlador;

import dao.TaskDAO;
import modelo.Task;
import modelo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la sesión actual o crear una nueva si no existe
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            // Si no hay sesión o el usuario no está autenticado, redirigir al login
            response.sendRedirect("index.jsp");
            return;
        }

        // Obtener el usuario desde la sesión
        User user = (User) session.getAttribute("user");

        // Obtener las tareas del usuario desde la base de datos
        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = taskDAO.getTasksByUserId(user.getUserId());
        System.out.println("Tareas obtenidas: " + tasks); // Depuración

        // Guardar las tareas en el request para ser mostradas en el JSP
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/task.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delegar al método doGet para manejar tanto GET como POST de la misma manera
        doGet(request, response);
    }
}
