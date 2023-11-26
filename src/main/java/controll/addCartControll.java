package controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import model.Product;

/**
 * Servlet implementation class addCartControll
 */
public class addCartControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCartControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		
		int addCart=(Integer) session.getAttribute("addCart");
		
		
		
		
		
		String pid=request.getParameter("pID");
		
		ProductDao dao = new ProductDao();
		
		Product c=dao.getProductId(pid);
		
		List<Product> list=(List<Product>) session.getAttribute("listCartProduct");
		
		List<Product> plist=dao.get5ProductCid(c.getcId());
		int dem=0;
		
		if(list.size()==0) {
			list.add(c);
			addCart++;
		}else {
		for(int i=0;i<list.size();i++) {
			if(c.getId() == list.get(i).getId()) {
				dem++;
			}
		}
		
		if(dem==0) {
			list.add(c);
			addCart++;
		}
		}
		
		
		
		
		session.setAttribute("listCartProduct",list);
		request.setAttribute("detail",c);
		request.setAttribute("listPP", plist);
		
		session.setAttribute("addCart",addCart);
		
		request.getRequestDispatcher("views/detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
