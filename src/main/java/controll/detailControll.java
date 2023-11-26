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
 * Servlet implementation class detailControll
 */
public class detailControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String pId= request.getParameter("pid");
		CategoryDao cdao=new CategoryDao();
		List<Category> list=cdao.getAllCatgory();
		
		
		ProductDao pdao=new ProductDao();
		
		Product product= pdao.getProductId(pId);
		
		List<Product> plist=pdao.get5ProductCid(product.getcId());
		
		request.setAttribute("detail",product);
		request.setAttribute("listC", list);
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
