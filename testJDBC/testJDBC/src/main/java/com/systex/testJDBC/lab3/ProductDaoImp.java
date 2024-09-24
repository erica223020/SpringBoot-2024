package com.systex.testJDBC.lab3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class ProductDaoImp implements ProductDao {

	@Autowired
	private ProductRowMapper productRowMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		SqlParameterSource namedParameters = new MapSqlParameterSource("productId",id);
		return (Product)this.namedParameterJdbcTemplate
				.queryForObject("select * from product where id=:productId", namedParameters, this.productRowMapper);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return (List<Product>)this.jdbcTemplate.query("select * from product", this.productRowMapper);
	}
	
	public int insert(Product product) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource params = new MapSqlParameterSource("name",product.getName())
				.addValue("desc", product.getDescription());
		this.namedParameterJdbcTemplate
			.update("insert into product(`name`,`desc`) values (:name,:desc)", params, keyHolder);
		return keyHolder.getKey().intValue();
	}
	
	@Override
	public void update(Product product) {
		SqlParameterSource params = new MapSqlParameterSource("id", product.getProductId())
				.addValue("name", product.getName())
				.addValue("desc", product.getDescription());
		this.namedParameterJdbcTemplate
			.update("update product set product.name=:name, product.desc=:desc where id=:id", params);
	}

}
