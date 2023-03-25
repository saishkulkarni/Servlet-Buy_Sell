package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Customer;

@WebServlet("/signup")
public class Signup extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String mobile=req.getParameter("mobile");
	String password=req.getParameter("password");
	String gender=req.getParameter("gender");
	String dob=req.getParameter("dob");
	String address=req.getParameter("address");
	
	Date date=Date.valueOf(dob);
	
	int age=Period.between(date.toLocalDate(), LocalDate.now()).getYears();
	
	
	
	Customer customer=new Customer();
	customer.setName(name);
	customer.setEmail(email);
	customer.setMobile(Long.parseLong(mobile));
	customer.setPassword(password);
	customer.setGender(gender);
	customer.setDob(date);
	customer.setAddress(address);
	customer.setAge(age);
	
	
	
	
	
}
}
