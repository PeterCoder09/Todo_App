<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="modelo.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="dao.TaskDAO"%>
<%
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp"); // Redirigir al login si no hay sesión
    } else {
        // Obtener el usuario desde la sesión
        modelo.User user = (modelo.User) session.getAttribute("user");

        // Obtener las tareas del usuario desde la base de datos
        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = taskDAO.getTasksByUserId(user.getUserId());
        request.setAttribute("tasks", tasks);
    }
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tareas</title>
        <!-- Incluir Tailwind CSS -->
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
        <!-- Incluir Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100 min-h-screen flex items-center justify-center py-6 px-4 sm:px-6 lg:px-8">
        <div class="bg-white rounded-lg border p-6 w-full max-w-4xl">
            <div class="mb-6">
                <h2 class="text-2xl font-bold">Tareas</h2>
                <p class="text-sm text-gray-500">Gestiona tus tareas pendientes.</p>
            </div>
            <div class="overflow-x-auto">
                <table class="min-w-full divide-y divide-gray-200">
                    <thead class="bg-gray-50">
                        <tr>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Título</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Descripción</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Estado</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Vencimiento</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Prioridad</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Creado</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actualizado</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Acciones</th>
                        </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-200">
                        <c:forEach var="task" items="${tasks}">
                            <tr>
                                <td class="px-6 py-4 whitespace-nowrap">${task.taskId}</td>
                                <td class="px-6 py-4 whitespace-nowrap">${task.title}</td>
                                <td class="px-6 py-4 whitespace-nowrap">${task.description}</td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <span class="bg-green-500 text-green-50 px-2 py-1 rounded-sm">${task.status}</span>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap">${task.dueDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.US))}</td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <span class="bg-yellow-500 text-yellow-50 px-2 py-1 rounded-sm">${task.priority}</span>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap">${task.createdAt}</td>
                                <td class="px-6 py-4 whitespace-nowrap">${task.updatedAt}</td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <div class="dropdown">
                                        <button class="btn btn-info dropdown-toggle" type="button" id="accionesMenu${task.taskId}" data-bs-toggle="dropdown" aria-expanded="false">
                                            Acciones
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="accionesMenu${task.taskId}">
                                            <li><a class="dropdown-item" href="ControllerActionsTask?action=editar&taskId=${task.taskId}">Editar</a></li>
                                            <li><a class="dropdown-item" href="cambiarEstadoTask?taskId=${task.taskId}">Cambiar Estado</a></li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${empty tasks}">
                    <p class="text-center mt-4">No hay tareas disponibles.</p>
                </c:if>
            </div>
        </div>
        <!-- Incluir Popper y Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>