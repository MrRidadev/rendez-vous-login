package Web;


import DAO.UsersDao;
import Module.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/")
public class UsersServler extends HttpServlet {


    private UsersDao usersDao = new UsersDao();
    public void init(){
        usersDao = new UsersDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/addlogin":
                    LoginUser(request, response);
                    break;
                    case "/login":
                        LoginPage(request, response);
                        break;
                        case "/logincheck":
                            checklogin(request, response);
                            break;

                default:
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
    public void checklogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String motPass = request.getParameter("motpass");

        String role= usersDao.authenticateUser(email, motPass);

        if (role != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", role);
            switch (role) {
                case "patient":
                    RequestDispatcher rd = request.getRequestDispatcher("dashbord.jsp");
                    rd.forward(request, response);
                    break;
                case "doctor":
                    RequestDispatcher rq = request.getRequestDispatcher("dashboardDR.jsp");
                    rq.forward(request, response);
                    break;
                default:
                    response.sendRedirect("login.jsp?error=unauthorized");
                    break;
            }
        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
    private void LoginPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

       RequestDispatcher rd = request.getRequestDispatcher("singup.jsp");
       rd.forward(request, response);

    }

    private void LoginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String username = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("motpasse");
        String telephone = request.getParameter("tele");
        String specialisation = request.getParameter("specialisation");
        String role = request.getParameter("role");
        Users users = new Users(username,email,password,telephone,specialisation,role);
        usersDao.insertUsers(users);
        System.out.println(users);
        response.sendRedirect("index.jsp");

    }
}
