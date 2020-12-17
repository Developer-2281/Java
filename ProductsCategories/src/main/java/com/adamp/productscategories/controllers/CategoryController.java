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
public class CategoryController {
	private final MainService mainService;
	
	public CategoryController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@GetMapping("/test")
	public String test() {
		return "test.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategories.jsp";
	}
	
	@PostMapping("/categories/new")
	public String processCat(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategories.jsp";
		}
		else {
			mainService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@GetMapping("/categories/{id}")
	public String showCat(@PathVariable("id")Long id, Model model) {
		Category category = mainService.findCategoryById(id);
		List<Product> allProducts = mainService.getAllProducts();
		model.addAttribute("category", category);
		model.addAttribute("products", allProducts); //Make sure both are plural	
		return "showCategory.jsp";
	}
	
	@PostMapping("/categories")
	public String prodToCat(@RequestParam("category_id")Long category_id, @RequestParam("product_id") Long product_id) {
		
		//								  Relationship join names
		
		Product product = mainService.findProductById(product_id);
		Category category = mainService.findCategoryById(category_id);
		category.getProducts().add(product);
//		product.getCategories().add(category); you only need to do one.
		mainService.createCategory(category);
		System.out.println("The product id is " + product_id);
		System.out.println("The category id is" + category_id);
		String id = String.valueOf(category_id); // allows you to add id to url
		return "redirect:/categories/" + id ;
		
	}
}





