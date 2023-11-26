package controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;
import model.Account;
import model.Product;

/**
 * Servlet implementation class LoginControll
 */
public class LoginControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControll() {
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
		
		request.setCharacterEncoding("UTF-8");
		
		String user =request.getParameter("username");
		String pass=request.getParameter("password");
		
		AccountDao dao=new AccountDao();
		
		Account c=dao.checkSignIn(user, pass);
		String check="";
		
		
		
		
		
		if(c ==null) {
			check="Wrong user or pass";
			request.setAttribute("check",check);
			request.setAttribute("user",user);
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}else {
			
			int addCart=0;
			HttpSession session =request.getSession();
			
			List<Product>  list=new ArrayList<Product>();
			
			session.setAttribute("listCartProduct", list);
			session.setAttribute("acc",c);
			session.setAttribute("addCart", addCart);
			request.getRequestDispatcher("HoneControll").forward(request, response); //dùng khi truyền theo dữ liệu dến trang đó
			//response.sendRedirect("HoneControll"); // dùng khi chuyển trang mà không mang theo dữ liệu vào trang
 
			
		}
		
		
	}

}
