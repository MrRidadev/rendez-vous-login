package Web;

import DAO.UsersDao;
import Module.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

UsersDao usersDao = new UsersDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String motPass = request.getParameter("motPass");

        Users user = usersDao.authenticateUser(email, motPass);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Vérification du rôle de l'utilisateur
            switch (user.getRole()) {
                case "patient":
                    response.sendRedirect("dashboardPatient.jsp");
                    break;
                case "doctor":
                    response.sendRedirect("dashboardDoctor.jsp");
                    break;
                default:
                    response.sendRedirect("login.jsp?error=unauthorized");
                    break;
            }
        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }







}
