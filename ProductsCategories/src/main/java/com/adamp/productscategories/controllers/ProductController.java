package com.adamp.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adamp.productscategories.models.Category;
import com.adamp.productscategories.models.Product;
import com.adamp.productscategories.services.MainService;

@Controller
public class ProductController {
	private final MainService mainService;
	
	public ProductController(MainService mainService) {
		this.mainService = mainService;
	}

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProducts.jsp";
	}
	
	@PostMapping("/products/new")
	public String processProd(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProducts.jsp";
		}
		else {
			mainService.createProduct(product);
			return "redirect:/products/new";
		}
		
	}
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = mainService.findProductById(id);
		List<Category> allCats = mainService.getAllCategories();
		model.addAttribute("product", product);
		model.addAttribute("categories", allCats); //Make sure both are plural	
		return "showProduct.jsp";
		
	}

	@PostMapping("/products")
	public String catToProd(@RequestParam("product_id")Long product_id, @RequestParam("category_id") Long category_id) {

		//								  Relationship join names
	
		Product product = mainService.findProductById(product_id);
		Category category = mainService.findCategoryById(category_id);
		product.getCategories().add(category);
//		category.getProducts().add(product); only need to add one.
		mainService.createProduct(product);
		System.out.println("The product id is " + product_id);
		System.out.println("The category id is" + category_id);
		String id = String.valueOf(product_id); // allows you to add id to url
		return "redirect:/products/" + id;
		
	}
}





