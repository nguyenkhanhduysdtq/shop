package controll;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;

/**
 * Servlet implementation class loadCartProduct
 */
public class loadCartProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadCartProduct() {
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
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session =request.getSession();
		
		List<Product> list= (List<Product>) session.getAttribute("listCartProduct");
		
		BigDecimal sumMoney= new BigDecimal(0);
		 BigDecimal paySumMoney;
		 
		 DecimalFormat df = new DecimalFormat();
		 
		 
		 for(int i=0;i<list.size();i++) {
			 sumMoney= sumMoney.add(list.get(i).getPrice());
		 }
		 
		 
		 paySumMoney = sumMoney.add(sumMoney.multiply(new BigDecimal(0.1)));
		
		 
		 
		 request.setAttribute("sumMoney",sumMoney);
		 request.setAttribute("paySumMoney",df.format(paySumMoney));
		
		request.setAttribute("list",list);
		
		
		
		request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
		
		
	}

}
