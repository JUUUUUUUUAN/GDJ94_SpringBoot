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
	public void list(Model model) throws Exception {
		List<ProductDTO> list =  productService.list();
		model.addAttribute("list", list);
	}
	
	@GetMapping("add")
	public void add() throws Exception {
	}
	
	@PostMapping("add")
	public String add(ProductDTO productDTO) throws Exception {
		productService.add(productDTO);
		
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public void detail(ProductDTO productDTO, Model model) throws Exception {
		productDTO =  productService.detail(productDTO);
		model.addAttribute("product", productDTO);
	}
	
	@GetMapping("update")
	public String update(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.detail(productDTO);
		// System.out.println(productDTO.toString());
		model.addAttribute("product", productDTO);
		
		return "/product/add";
	}
	
	@PostMapping("update")
	public String update(ProductDTO productDTO) throws Exception {
		productService.update(productDTO);
		return "redirect:./list";
	}
	
	@GetMapping("delete")
	public String delete(ProductDTO productDTO) throws Exception {
		int result = productService.delete(productDTO);
		
		if(result > 0) {
			return "commons/result";
		}
		return "redirect:./list";			
	}
	
}
