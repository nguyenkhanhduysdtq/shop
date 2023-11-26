package controll;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.CategoryDao;
import dao.ProductDao;
import model.Category;
import model.Product;

/**
 * Servlet implementation class SendEmailControll
 */
public class SendEmailControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("/views/SendEmail.jsp").forward(request, response);
    
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html;charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		
		final String username="nduy26825@gmail.com";
		final String password="hizbqqjapakfllmk";
		
		Properties props=new Properties();
		
		
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		javax.mail.Session session=javax.mail.Session.getInstance(props,new Authenticator() {
		    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
		    	return new javax.mail.PasswordAuthentication(username, password);
		    }
		
		});
		
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String placeSpecific=request.getParameter("placeSpecific");
		String sumMoney=request.getParameter("SumPayMoney");
		String select=request.getParameter("select");	
		HttpSession session1= request.getSession();
		
		@SuppressWarnings("unchecked")
		List<Product> list=(List<Product>) session1.getAttribute("listCartProduct");
		String plist="";
		
		for(int i=0;i<list.size();i++) {
			plist=plist+list.get(i).getName()+" , " +list.get(i).getDescription() +" , "+list.get(i).getPrice() +"$| ";
		}
		
		ProductDao dao=new ProductDao();
		
int quatity=dao.getQuantityProduct();
		
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
		
		
		List<Product> listP = dao.pagingProduct(index,28,27);
		
		
		request.setAttribute("listP",listP);
		
		
		
CategoryDao categoryDao=new CategoryDao();
		
		List<Category> listC=categoryDao.getAllCatgory();
		
		
		request.setAttribute("listC",listC);
		
		String tranfer;
		
		if(select.equalsIgnoreCase("1")) {
			
			tranfer="Chuyển khoan trước khi nhận hàng";
			
		}else {
			tranfer="Thanh toán sau khi nhận hàng ";
		}
		
		
		try {
			MimeMessage message=new MimeMessage(session);
			message.addHeader("Content-type","text/html;charset=UTF-8");
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email,false));
			
			message.setSubject("Thông báo đơn hàng !");
			message.setContent(
					"<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<body>\r\n"
					+ "    <p>Họ tên: "+name+"</p>\r\n"
					+ "    <p>Số điện thoại : "+phone+"</p>\r\n"
					+ "    <p>Email : "+email+"</p>\r\n"
					+ "    <p>Thông tin sản phẩm : "+plist+"</p>\r\n"
					+ "    <p>Địa chỉ gửi hàng: "+placeSpecific+"</p>\r\n"
					+ "    <p>Tổng tiền thanh toán : "+sumMoney+"$"+"</p>\r\n"
					+ "    <p>Hình thức thanh toán : "+tranfer+"</p>\r\n"
					+ "    <p>Cảm ơn khác hàng đã tin tưởng!</p>\r\n"
					+ "</body>\r\n"
					+ "</html>","text/html;charset=UTF-8");
			
			
			session1.setAttribute("addCart","0");
			session1.setAttribute("listCartProduct",new ArrayList<Product>());
			
			Transport.send(message);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("lỗi");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/views/home.jsp").forward(request, response);
		
	}

}

