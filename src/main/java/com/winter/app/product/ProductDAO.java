package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {

	public void add(ProductDTO productDTO) throws Exception;
	
	public List<ProductDTO> list() throws Exception;
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception;
	
	public int update(ProductDTO productDTO) throws Exception;
	
	public int delete(ProductDTO productDTO) throws Exception;
}
