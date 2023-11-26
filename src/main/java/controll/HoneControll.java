package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import dao.ProductDao;
import model.Account;
import model.Category;
import model.Product;

/**
 * Servlet implementation class HoneControll
 */
public class HoneControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoneControll() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		ProductDao productDao=new ProductDao();
		CategoryDao categoryDao=new CategoryDao();
		
		List<Category> listC=categoryDao.getAllCatgory();
		
		
		request.setAttribute("listC",listC);
		
		
		
		int quatity=productDao.getQuantityProduct();
		
		int page=quatity/28;
		
		if(page %28 !=0) {
			page++;
		}
		
		
		
		
		request.setAttribute("page",page);
		
		
		int index;
		String pages=request.getParameter("pages");
		
		if(pages == null) {
		 index=1;
		}else {
			index=Integer.parseInt(pages);
		}
		
		
		request.setAttribute("index", index);
		
		
		List<Product> listP = productDao.pagingProduct(index,28,27);
		
		
		request.setAttribute("listP",listP);
		
		HttpSession session=request.getSession();
		Account c= (Account) session.getAttribute("acc");
		
		if( c ==null) {
			session.setAttribute("addCart",0);
		}
		
		
		
		
		   
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
