package Servlet;

import java.io.File;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import Bean.Method;

@WebServlet(urlPatterns ="/insert")
public class Insert extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		MultipartRequest mr=new MultipartRequest(req,"C:\\Users\\pp\\eclipse-workspace\\MegaMart\\WebContent\\images");
		
		String ProdName=mr.getParameter("name");
		String ProDesc=mr.getParameter("desc");
		
		File file=mr.getFile("image");
		String image_name=file.getName();
		String image_path="http://localhost:9090/MegaMart/images/"+image_name;
		
		String ProPrize=mr.getParameter("prize");
		
		Method Me=new Method();
		Me.setProduct_Name(ProdName);
		Me.setProduct_Description(ProDesc);
		Me.setProduct_Image(image_path);
		Me.setProduct_Prize(ProPrize);
		
		RequestDispatcher rd=req.getRequestDispatcher("Index.jsp");
		try
		{
			int res=Me.addProduct();
			if(res==1)
			{
			     req.setAttribute("msg", "Succesfully inserted");
			}
			else
			{
				req.setAttribute("msg", "failed");
			}
			rd.forward(req, resp);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
