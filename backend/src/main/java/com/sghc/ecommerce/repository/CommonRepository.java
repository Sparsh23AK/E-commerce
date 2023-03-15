package com.sghc.ecommerce.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sghc.ecommerce.entity.ProductResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CommonRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public List<ProductResponse> getProductDetails(String category){
		String sql = "SELECT PM.product_id, PM.description, PM.discount_percentage, PM.price, PM.product_category, PM.rating, PM.`size`,\r\n"
				+ "PM.sub_description, PM.`type`,\r\n"
				+ "pi2.image_id, pi2.image_data, pi2.image_name, pi2.image_type\r\n"
				+ "FROM Ecommerce.products_master PM JOIN Ecommerce.product_images pi2 ON PM.product_id = pi2.product_id \r\n"
				+ "WHERE PM.product_category= ? ";
		
		return jdbcTemplate.query(sql,new ProductDetailMapper(),new Object[] {category});
	}
	
	private class ProductDetailMapper implements RowMapper<ProductResponse> {
		   public ProductResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
			   ProductResponse pr =new ProductResponse();  
			   
			   pr.setProductId(rs.getInt("product_Id"));
			   System.out.println(pr.getProductId()+ " :ID");
			   pr.setDescription(rs.getString("description"));
			   pr.setDiscountPercentage(rs.getInt("discount_percentage"));
			   pr.setPrice(rs.getDouble("price"));
			   pr.setProductCategory(rs.getString("product_category"));
			   pr.setRating(rs.getFloat("rating"));
			   pr.setSubDescription(rs.getString("sub_description"));
			   pr.setSize(rs.getString("size"));
			   pr.setType(rs.getString("type"));
			   pr.setImageId(rs.getInt("image_id"));
			   pr.setImageType(rs.getString("image_type"));
			   pr.setImageName(rs.getString("image_name"));
			   pr.setImageData((rs.getBytes("image_data")));
			   
			   double disPrice = pr.getPrice() - (pr.getPrice() * pr.getDiscountPercentage())/100;
			   pr.setDiscountPrice(disPrice);
			   
		        return pr; 
		   }
		}
	
}
