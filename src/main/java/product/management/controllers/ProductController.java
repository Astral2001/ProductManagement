package product.management.controllers;

import product.management.models.Product;
import product.management.service.impl.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductServiceImpl productService;
	
	@GetMapping("")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "/product/products";
	}
	
	@GetMapping("/add-product")
	public String addProduct_Get (Model model) {
		Product product = new Product();
		
		model.addAttribute("product", product);
		
		return "/product/add-product";
	}
	
	@GetMapping("/add-product")
	public String addProduct_Pos (Model model, 
			 @ModelAttribute(name = "product") Product product) {
		productService.createProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/update-product/{id}")
	public String updateProduct_Get (Model model, 
			@PathVariable(name = "id") Long id) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "/product/product";
	}
	
	@PostMapping("/update-product/{id}")
	public String updateProduct_Post (Model model, 
			@PathVariable(name = "id") Long id
			, @ModelAttribute(name = "product") Product product) {
		productService.updateProduct(id, product);
		return "redirect:/products";
	}
	
	@GetMapping("/delete-product/{id}")
	public String deleteProduct_Get (Model model
			, @PathVariable(name = "id") Long id) {
		
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "/product/delete-product";
	}
	
	@PostMapping("/delete-product/{id}")
	public String deleteProduct_Post (HttpServletRequest request , Model model
			, @PathVariable(name = "id") Long id) {
		
		String choose = request.getParameter("choose");
		if (choose.equals("yes")){
			productService.deleteProduct(productService.getProductById(id));
		}
		return "redirect:/products";
	}
}
