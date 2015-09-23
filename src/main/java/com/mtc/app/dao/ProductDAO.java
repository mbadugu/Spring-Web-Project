package com.mtc.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mtc.app.entity.Product;

@Repository
public class ProductDAO implements IProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ProductRowMapper productRowMapper;
	
	@Autowired
	private ProductPreparedStatementSetter preparedStatementSetter;
	
//	@Autowired
//	private Product product;

	public void addProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
			session.save(product);
		transaction.commit();
	session.close();
	}

	public Product getproductById(int id) {
		Session session = sessionFactory.openSession();
		Product product = (Product)session.get(Product.class, id);
		return product;
	}

	public List<Product> getproducts() {
String selectQuery = "select * from test.product";
		
		List<Product> products = jdbcTemplate.query(selectQuery,productRowMapper);

		return products;
	}

	public Float getMaxPrice() {
//		Session session = sessionFactory.openSession();
//		session.
		
		// TODO Auto-generated method stub
String maxPriceQuery = "select max(product_price) from test.product";
		
		Float price = jdbcTemplate.queryForObject(maxPriceQuery, Float.class);
		
		return price;
	}

	public void addProducts(List<Product> products) {

		String insertQuery = "insert into test.product(product_id,product_name,product_price,product_description)"
				+ "values(?,?,?,?)";
		
		preparedStatementSetter.setProductsList(products);
		
		jdbcTemplate.batchUpdate(insertQuery,preparedStatementSetter);
		
	}

}
