package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;
import dao.CategoryDao;
import dao.ProductDao;
import model.Account;
import model.Category;
import model.Product;

/**
 * Servlet implementation class ManagerControll
 */
public class ManagerControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		
		Account a=(Account) session.getAttribute("acc");
		ProductDao dao=new ProductDao();
		CategoryDao cdao=new CategoryDao();
		
		int quatity=dao.getQuantityProductSellId(Integer.toString(a.getId()));
		
		int page=quatity/3;
		
		if(quatity % 3 !=0) {
			page++;
		}
		
		int index;
		
		if(request.getParameter("pageid") == null) {
			index=1;
		}else {
			index=Integer.parseInt(request.getParameter("pageid"));
		}
		
		List<Category> clist=cdao.getAllCatgory();
		
		List<Product> list=dao.pagingProductSellId(index,3,2,a.getId());
		
		request.setAttribute("listPP", list);
		request.setAttribute("listCC", clist);
		request.setAttribute("page",page);
		
		request.getRequestDispatcher("/views/ManagerProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
