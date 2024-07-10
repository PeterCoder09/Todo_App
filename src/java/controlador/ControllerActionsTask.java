package controlador;

import dao.TaskDAO;
import modelo.Task;
import modelo.TaskPriority;
import modelo.TaskStatus;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerActionsTask", urlPatterns = {"/ControllerActionsTask"})
public class ControllerActionsTask extends HttpServlet {

    private TaskDAO taskDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        taskDAO = new TaskDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String actionTask = request.getParameter("action");

        if (actionTask == null) {
            actionTask = "";
        }

        switch (actionTask) {
            case "editar":
                int taskId = Integer.parseInt(request.getParameter("taskId"));
                Task task = taskDAO.getTaskById(taskId);
                if (task != null) {
                    request.setAttribute("task", task);
                    request.getRequestDispatcher("./WEB-INF/viewsActions/editTask.jsp").forward(request, response);
                } else {
                    // Manejar el caso cuando no se encuentra la tarea
                    response.sendRedirect("task.jsp"); // Redirigir a otra página por ejemplo
                }
                break;
            case "actualizar":
                actualizarTarea(request, response);
                break;
            default:
                response.sendRedirect("task.jsp");
                break;
        }
    }

    private void actualizarTarea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        TaskStatus status = TaskStatus.valueOf(request.getParameter("status"));
        LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"));
        TaskPriority priority = TaskPriority.valueOf(request.getParameter("priority"));
        LocalDateTime updatedAt = LocalDateTime.parse(request.getParameter("updatedAt"));

        Task task = new Task(taskId, title, description, status, dueDate, priority, null, updatedAt, 0); // UserId temporal, debes manejarlo correctamente según tu lógica

        boolean updated = taskDAO.updateTask(task);
        if (updated) {
            response.sendRedirect("task.jsp"); // Redirigir a la página principal de tareas o donde sea adecuado
        } else {
            // Manejar el caso cuando no se puede actualizar la tarea
            response.sendRedirect("task.jsp"); // Redirigir a otra página por ejemplo
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
