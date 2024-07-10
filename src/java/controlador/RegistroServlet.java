package controlador;

import dao.UserDAO;
import modelo.User;
import modelo.UserStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/registroServlet")
public class RegistroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(0, username, email, password, LocalDateTime.now(), LocalDateTime.now(), UserStatus.ACTIVE);

        UserDAO userDAO = new UserDAO();
        boolean isUserAdded = userDAO.addUser(user);

        if (isUserAdded) {
            response.sendRedirect("index.jsp"); // Redirige a la página de inicio de sesión después del registro
        } else {
            request.setAttribute("errorMessage", "Hubo un error al crear la cuenta.");
            request.getRequestDispatcher("sing_up.jsp").forward(request, response);
        }
    }
}
