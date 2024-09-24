package com.systex.testJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.systex.testJDBC.lab3.Product;
import com.systex.testJDBC.lab3.ProductDao;

@SpringBootApplication
public class TestJdbcApplication implements CommandLineRunner{

	@Autowired
	private ProductDao productDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TestJdbcApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		Product product = new Product();
		product.setName("Elephant");
		product.setDescription("This is an elephant");
		System.out.println(this.productDao.insert(product));

		this.productDao.getProducts().forEach(p->System.out.println(p));
		System.out.println("================");
		System.out.println(productDao.getProduct(1));
		System.out.println(productDao.getProduct(2));
		Product p1 = new Product();
		p1.setProductId(1);
		p1.setName("Monkey");
		p1.setDescription("This is a monkey");
		
		productDao.update(p1);
		System.out.println("================");
		this.productDao.getProducts().forEach(p->System.out.println(p));
	}

}
