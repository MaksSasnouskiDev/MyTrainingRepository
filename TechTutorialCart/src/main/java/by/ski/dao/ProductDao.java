package by.ski.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import by.ski.model.Cart;
import by.ski.model.Product;

public class ProductDao {

	private Connection con;
	private String query;
	private PreparedStatement prepStnt;
	private ResultSet resultSet;

	public ProductDao(Connection con) {
		this.con = con;
	}

	public List<Product> getAllProducts() {
		
		List<Product> products = new ArrayList<>();

		try {
			query="select*from products order by id";
			prepStnt=con.prepareStatement(query);
			
			resultSet= prepStnt.executeQuery();
			
			while(resultSet.next()) {
				Product prod=new Product();
				prod.setId(resultSet.getInt("id"));
				prod.setName(resultSet.getString("name"));
				prod.setDescription(resultSet.getString("description"));
				prod.setPrice(resultSet.getDouble("price"));
				prod.setImage(resultSet.getString("image"));
				
				products.add(prod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Cart> getCartProducts(ArrayList<Cart>cartList){
		
		List<Cart>products=new ArrayList<>();
		
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query="select*from products where id=?";
					prepStnt=con.prepareStatement(query);
					prepStnt.setInt(1,item.getId());
					
					resultSet=prepStnt.executeQuery();
					
					while(resultSet.next()) {
						Cart row=new Cart();
						row.setId(resultSet.getInt("id"));
						row.setName(resultSet.getString("name"));
						row.setDescription(resultSet.getString("description"));
						row.setPrice(resultSet.getDouble("price")
							*item.getQuantity());
						row.setQuantity(item.getQuantity());
						
						products.add(row);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}

}
