package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDao;
import dao.CategoryDao;
import dao.ProductDao;
import model.Account;
import model.Category;
import model.Product;

/**
 * Servlet implementation class EditControll
 */
public class EditControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		  String id=request.getParameter("id");
//        String name=request.getParameter("name");
//        String image=request.getParameter("image");
//        String price=request.getParameter("price");
//        String discription=request.getParameter("description");
//        String Cid=request.getParameter("category");
        
        String pid=request.getParameter("pId");
        
        ProductDao dao=new ProductDao();
        
        Product c=dao.getProductId(pid);
        
        CategoryDao cdao=new CategoryDao();
        
        List<Category> list=cdao.getAllCatgory();
        
        Category category=cdao.findOnebyID(c.getcId());
        
        request.setAttribute("cid",category);
        
        request.setAttribute("p",c);
        
        request.setAttribute("listCC",list);
        
        request.getRequestDispatcher("views/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}
		

}
