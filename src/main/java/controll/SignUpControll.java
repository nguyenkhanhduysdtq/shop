package controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDao;
import model.Account;

/**
 * Servlet implementation class SignUpControll
 */
public class SignUpControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String user= request.getParameter("Username");
		String pass=request.getParameter("password");
		String cPass=request.getParameter("Cpassword");
		Account ac=new Account(0, user, pass, 0, 0);
		
		AccountDao dao=new AccountDao();
		
		Account c= dao.checkUserExist(user);

		
		if(pass.equals(cPass)) {
			if( c ==null) {
				dao.insertAccount(ac);
				response.sendRedirect("http://localhost:8080/shop/views/login.jsp");
			}else {
				request.setAttribute("check","input user was exist");
				request.setAttribute("cuser",user);
			    request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
				
			}
			
		}else {
			response.sendRedirect("http://localhost:8080/shop/views/signup.jsp");
		}
	}

}
