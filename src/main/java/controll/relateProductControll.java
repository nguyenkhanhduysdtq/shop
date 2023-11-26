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
 * Servlet implementation class relateProductControll
 */
public class relateProductControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public relateProductControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String pid=request.getParameter("idpp");
		
		CategoryDao cdao=new CategoryDao();
		ProductDao pdao=new ProductDao();
		
		List<Category> clist=cdao.getAllCatgory();
		
		Product product=pdao.getProductId(pid);
		
		List<Product> plist=pdao.get5ProductCid(product.getcId());
		
		
		request.setAttribute("detail",product);
		request.setAttribute("listC", clist);
		request.setAttribute("listPP",plist);
		
		request.getRequestDispatcher("/views/detail.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
