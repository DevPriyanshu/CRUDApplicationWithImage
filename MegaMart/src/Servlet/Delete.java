package Servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Method;
@WebServlet(urlPatterns = "/del")
public class Delete extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int proid=Integer.parseInt(req.getParameter("Product_Id"));
		
	    Method m=new Method();
	    m.setProduct_Id(proid);
	    RequestDispatcher rd=req.getRequestDispatcher("Index.jsp");
	    try {
			int res=m.DeleteProduct();
			if(res==1)
			{
				req.setAttribute("msg", "Succes");
			}
			else
			{
				req.setAttribute("msg", "Failed");
			}
			rd.forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
}
