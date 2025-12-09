package com.winter.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.users.UserDTO;
import com.winter.app.util.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public void add(ProductDTO productDTO) throws Exception {
		productDAO.add(productDTO);
	}
	
	public List<ProductDTO> list() throws Exception {
		return productDAO.list();
	}
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		return productDAO.detail(productDTO);
	}
	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}
	public int delete(ProductDTO productDTO) throws Exception{
		return productDAO.delete(productDTO);
	}
	
	//-----------------------------------------------
	public List<ProductCommentDTO> commentList(ProductCommentDTO productCommentDTO, Pager pager) throws Exception{;
		pager.setPerPage(5L);
		Map<String, Object> map = new HashMap<>();
		map.put("product", productCommentDTO);
		map.put("pager", pager);
		pager.pageing(productDAO.commentCount(productCommentDTO));
		return productDAO.commentList(map);
	}
	
	public int commentAdd(ProductCommentDTO productCommentDTO) throws Exception{
		return productDAO.commentAdd(productCommentDTO);
	};
	
	public int cartAdd(ProductDTO producDTO, UserDTO userDTO) throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		map.put("product", producDTO);
		map.put("user", userDTO);
		return productDAO.cartAdd(map);
	}
	
	public List<ProductDTO> cart(UserDTO userDTO) throws Exception {
		return productDAO.cart(userDTO);
	}
}
