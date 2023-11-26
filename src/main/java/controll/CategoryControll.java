package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import model.Category;
import model.Product;

/**
 * Servlet implementation class CategoryControll
 */
public class CategoryControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String cateId=request.getParameter("id");
		
		CategoryDao dao=new CategoryDao();
		
		List<Category> listC=dao.getAllCatgory();
		List<Product> list=dao.getProductCateId(cateId);
		
		request.setAttribute("listC",listC);
		request.setAttribute("listP",list);
		request.setAttribute("tag",cateId);
		
		request.getRequestDispatcher("/views/home.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
