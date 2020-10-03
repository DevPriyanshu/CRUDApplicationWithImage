package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connector.Connect;


public class Method 
{
	String Product_Name,Product_Description,Product_Image,Product_Prize;
	int Product_Id;
	
	public int getProduct_Id() {
		return Product_Id;
	}

	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	public String getProduct_Description() {
		return Product_Description;
	}
	public void setProduct_Description(String product_Description) {
		Product_Description = product_Description;
	}
	public String getProduct_Image() {
		return Product_Image;
	}
	public void setProduct_Image(String product_Image) {
		Product_Image = product_Image;
	}
	public String getProduct_Prize() {
		return Product_Prize;
	}

	public void setProduct_Prize(String product_Prize) {
		Product_Prize = product_Prize;
	}
	
	public int addProduct()throws SQLException
	{
		Connection con=Connect.Mega();
		
		String Sql="insert  into product (Product_Name,Product_Description,Product_Image, Product_Prize) values(?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(Sql);
		ps.setString(1,Product_Name);
		ps.setString(2, Product_Description);
		ps.setString(3, Product_Image);
		ps.setString(4, Product_Prize);
		
		int res=ps.executeUpdate();
		return res;
	}
	public int DeleteProduct()throws SQLException
	{
		Connection con=Connect.Mega();
		 
		String sql="delete from product where Product_Id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,Product_Id);
		int res=ps.executeUpdate();
		return res;
	}
	public int UpdateProduct()throws SQLException
	{
		Connection con=Connect.Mega();
		
		String sql="update product set  Product_Name=?,Product_Description=?,Product_Image=?,Product_prize=? where Product_Id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, Product_Name);
		ps.setString(2, Product_Description);
		ps.setString(3, Product_Image);
		ps.setString(4, Product_Prize);
		ps.setInt(5, Product_Id);
		
		int res=ps.executeUpdate();
		return res;
	}
	public ArrayList<Method> ShowAllProduct()throws SQLException
	{
		Connection con=Connect.Mega();
		String sql="Select *from product";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		ArrayList<Method> allPro=new ArrayList<>();
		
		while(rs.next()) 
		{
			int pid=rs.getInt("Product_Id");
			String PName=rs.getString("Product_Name");
			String PDesc=rs.getString("Product_Description");
			String PImage=rs.getString("Product_Image");
			String PPrize=rs.getString("Product_Prize");
			
			Method m=new Method();
			
			m.setProduct_Id(pid);
			m.setProduct_Name(PName);
			m.setProduct_Description(PDesc);
			m.setProduct_Image(PImage);
			m.setProduct_Prize(PPrize);
			
			allPro.add(m);
		}
		return allPro;	
	}
	public Method getProduct()throws SQLException
	{
		Connection con=Connect.Mega();
		String Sql="Select *from product where Product_Id=?";
		PreparedStatement ps=con.prepareStatement(Sql);
		ps.setInt(1,Product_Id);
		
		ResultSet rs=ps.executeQuery();
		Method obj=new Method();
		
		if(rs.next())
		{
			int pid=rs.getInt("Product_Id");
			String pname=rs.getString("Product_Name");
			String PDesc=rs.getString("Product_Description");
			String PImg=rs.getString("Product_Image");
			String PPrize=rs.getString("Product_Prize");
			
			obj.setProduct_Id(pid);
			obj.setProduct_Name(pname);
			obj.setProduct_Description(PDesc);
			obj.setProduct_Image(PImg);
			obj.setProduct_Prize(PPrize);
		}
		return obj;
	}
}
