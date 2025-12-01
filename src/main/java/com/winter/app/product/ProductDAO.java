package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {

	public void add(ProductDTO productDTO);
	
	public List<ProductDTO> list();
}
