package buildapi;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.AccountDao;
import model.Account;
import utils.HttpUtils;

/**
 * Servlet implementation class NewAPI
 */
public class NewAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		 ObjectMapper mapper= new ObjectMapper();
		 Account account= HttpUtils.toAccount(Account.class,HttpUtils.jsonToString(request.getReader()).getValue());
		 
		 AccountDao dao=new AccountDao();
		 dao.insertAccount(account);
		 
		 mapper.writeValue(response.getOutputStream(),account);
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		 ObjectMapper mapper= new ObjectMapper();
		 Account account= HttpUtils.toAccount(Account.class,HttpUtils.jsonToString(req.getReader()).getValue());
		 
		 AccountDao dao=new AccountDao();
		
		 dao.updateAccount(account);
		 mapper.writeValue(resp.getOutputStream(),account);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		HttpUtils httpUtils=new HttpUtils();
		
		ObjectMapper mapper=new ObjectMapper();
		@SuppressWarnings("static-access")
		Account account=httpUtils.toAccount(Account.class,HttpUtils.jsonToString(req.getReader()).getValue());
		
		AccountDao dao=new AccountDao();
		dao.deleteAccount(account);
		
		mapper.writeValue(resp.getOutputStream(),"{}");
	}
}
