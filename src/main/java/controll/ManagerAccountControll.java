package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDao;
import model.Account;

/**
 * Servlet implementation class ManagerAccountControll
 */
public class ManagerAccountControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerAccountControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		AccountDao dao=new AccountDao();
		
		List<Account> list=dao.finallAccount();
	      
		request.setAttribute("listAccount", list);
		
		if(request.getParameter("message").equals("empty")) {
			request.setAttribute("check",0);
		}else if(request.getParameter("message").equals("success")){
			request.setAttribute("check",1);
		}else{
			request.setAttribute("check",2);
		}
		
		
		request.getRequestDispatcher("/views/listaccount.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
