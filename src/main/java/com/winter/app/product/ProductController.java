package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public void list(Model model) {
		List<ProductDTO> list =  productService.list();
		model.addAttribute("list", list);
	}
	
	@GetMapping("add")
	public void add() {
	}
	
	@PostMapping("add")
	public String add(ProductDTO productDTO) {
		productService.add(productDTO);
		
		return "redirect:./list";
	}
	
}
