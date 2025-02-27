package Web;

import DAO.UsersDao;
import Module.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hhgfh")
public class LoginServlet extends HttpServlet {




    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        Users user = UsersDao.getUser(username, password);

        if(username.equals("admin") && password.equals("admin")){
//            request.getSession().setAttribute("user",user);
            response.sendRedirect(request.getContextPath() +"dashbord.jsp");
        }else {
//            request.setAttribute("error","Invalid username or password");
            response.sendRedirect(request.getContextPath()+"login.jsp");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
