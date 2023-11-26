package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import model.Account;
import model.Product;

/**
 * Servlet implementation class DeleteControll
 */
public class DeleteControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String pid=request.getParameter("pid");
		
		
		ProductDao dao=new ProductDao();
		
		HttpSession session =request.getSession();
		
		 Account c=  (Account) session.getAttribute("acc");
		 
		 dao.deleteProductId(pid);
		 
		 int quatity=dao.getQuantityProductSellId(Integer.toString(c.getId()));
			
			int page=quatity/5;
			
			if(quatity % 5 !=0) {
				page++;
			}
			
			int index;
			
			if(request.getParameter("pageid") == null) {
				index=1;
			}else {
				index=Integer.parseInt(request.getParameter("pageid"));
			}
			
			List<Product> list=dao.pagingProductSellId(index,5,4,c.getId());
		
		 
		 request.setAttribute("listPP",list);
		 request.setAttribute("page",page);
		
		
		
		request.getRequestDispatcher("views/ManagerProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
