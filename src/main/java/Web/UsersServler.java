package Web;


import DAO.UsersDao;
import Module.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("")
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
                        case "/checklogin":
                            break;



                default:
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
    private void LoginPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

       RequestDispatcher rd = request.getRequestDispatcher("singup.jsp");
       rd.forward(request, response);

    }
    private void checklogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {



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
