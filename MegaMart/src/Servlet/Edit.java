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

@WebServlet(urlPatterns ="/edit")
public class Edit extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		MultipartRequest m=new MultipartRequest(req, "C:\\Users\\pp\\eclipse-workspace\\MegaMart\\WebContent\\images");
		int prod_id=Integer.parseInt(m.getParameter("prod_id"));
		String Prod_Description=m.getParameter("produdes");
		
		File file=m.getFile("prodfile");
		String image_name=file.getName();
		String image_path="http://localhost:9090/MegaMart/images/"+image_name;
		
		String Pro_Prize=m.getParameter("prodprize");
		String Prod_Name=m.getParameter("produn");
		
		Method me=new Method();
		me.setProduct_Id(prod_id);
		me.setProduct_Description(Prod_Description);
		me.setProduct_Image(image_path);
		me.setProduct_Prize(Pro_Prize);
		me.setProduct_Name(Prod_Name);
		
		RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
		try {
				int res=me.UpdateProduct();
				if(res==1)
				{
				req.setAttribute("msg", "Succes");
				}
			else
				{
				req.setAttribute("msg", "Failed");
				}
					rd.forward(req, resp);
				}
		catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
