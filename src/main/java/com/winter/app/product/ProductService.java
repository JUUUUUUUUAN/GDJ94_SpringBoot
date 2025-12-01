package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public void add(ProductDTO productDTO) {
		productDAO.add(productDTO);
	}
	
	public List<ProductDTO> list() {
		return productDAO.list();
	}
}
