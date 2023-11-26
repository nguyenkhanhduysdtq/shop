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
 * Servlet implementation class UpdateControll
 */
public class UpdateControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String discription=request.getParameter("description");
		String image=request.getParameter("image");
		String price=request.getParameter("price");
		String category=request.getParameter("category");
		
		ProductDao pdao=new ProductDao();
		
		HttpSession session =request.getSession();
		
		Account c=(Account) session.getAttribute("acc");
		
		
		pdao.updateProduct(id, name, discription, price, image, category);
		
		List<Product> list= pdao.getProductSellId(Integer.toString(c.getId()));
		
		
		
		request.setAttribute("listPP",list);
		
		
		
		request.getRequestDispatcher("views/ManagerProduct.jsp").forward(request, response);
		
		
	}

}
