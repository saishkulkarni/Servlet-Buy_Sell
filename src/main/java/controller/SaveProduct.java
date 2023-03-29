package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CustomerDao;
import dto.Product;

@WebServlet("/saveproduct")
@MultipartConfig
public class SaveProduct extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Product product=new Product();
	product.setName(req.getParameter("pname"));
	product.setDescription(req.getParameter("pdesc"));
	product.setPrice(Double.parseDouble(req.getParameter("pprice")));
	
	byte[] pic = null;
	Part filepart = req.getPart("pimage");
	if (filepart != null) {
		InputStream inputStream = filepart.getInputStream();
		pic = new byte[inputStream.available()];
		inputStream.read(pic);
	}
	
	product.setImage(pic);
	
	CustomerDao dao=new CustomerDao();
	dao.save(product);
	
	resp.getWriter().print("<h1 style='color:red'>Product is added for Sale</h1>");
	req.getRequestDispatcher("Home.jsp").include(req, resp);
	
}
}
