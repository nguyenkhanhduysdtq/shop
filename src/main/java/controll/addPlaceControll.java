package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.ProductDao;
import model.Category;
import model.Product;

/**
 * Servlet implementation class addPlaceControll
 */
public class addPlaceControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPlaceControll() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String street=request.getParameter("street");
		
		CategoryDao dao=new CategoryDao();
		
		ProductDao pdao=new ProductDao();
		
		
	
		
		List<Category> list=dao.getAllCatgory();
		
		String pid=request.getParameter("pid");
		
		Product c=pdao.getProductId(pid);
				List<Product> plist=pdao.get5ProductCid(c.getcId());
		
		request.setAttribute("listC", list);
		
		request.setAttribute("listPP",plist);
		request.setAttribute("street",street);
		
		request.setAttribute("detail",c);
		
		request.getRequestDispatcher("/views/detail.jsp").forward(request, response);
	}

}
