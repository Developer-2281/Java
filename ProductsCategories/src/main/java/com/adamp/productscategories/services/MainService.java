package com.adamp.productscategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adamp.productscategories.models.Category;
import com.adamp.productscategories.models.Product;
import com.adamp.productscategories.repositories.CategoryRepository;
import com.adamp.productscategories.repositories.ProductRepository;

@Service
public class MainService {
	private final ProductRepository proRepo;
	private final CategoryRepository catRepo;
	
	public MainService(ProductRepository proRepo, CategoryRepository catRepo) {
		this.proRepo = proRepo;
		this.catRepo = catRepo;
		
	}
	public ProductRepository getProRepo() {
		return proRepo;
	}
	public CategoryRepository getCatRepo() {
		return catRepo;
	}


	//------------------------Product Methods-----------------------//
	

	// Get all 
	public List<Product> getAllProducts() {
		return proRepo.findAll();  // removed .this
	}
	// Find  by ID
	public Product findProductById(Long id) {
		return proRepo.findById(id).orElse(null); // removed .this
	}

	// Create
	
	public void createProduct(Product product) {
		this.proRepo.save(product);
	}
	
	// delete
	public void deleteProduct(Long id) {
		proRepo.deleteById(id);
		return;
	}
	
	// Update 
	public Product updateProduct(Long id, String name, String description, Float price, List<Category> categories) {
		Product optionalProduct = this.findProductById(id);
		optionalProduct.setName(name);
		optionalProduct.setDescription(description);
		optionalProduct.setPrice(price);
		optionalProduct.setCategories(categories);
		return proRepo.save(optionalProduct);
		}

	//------------------------End Product Methods-----------------------//
	
	

	//------------------------Category Methods-----------------------//

	// Get all
	public List<Category> getAllCategories() {
		return catRepo.findAll();  // removed .this
	}
	// Find by ID
	public Category findCategoryById(Long id) {
		return catRepo.findById(id).orElse(null); // removed .this
	}

	// Create
	
	public void createCategory(Category category) {
		this.catRepo.save(category);
	}
	// delete
	public void deleteCategory(Long id) {
		catRepo.deleteById(id);
		return;
	}

	// Update 
	public Category updateCategory(Long id, String name, List<Product> products) {
		Category optionalCategory = this.findCategoryById(id);
		optionalCategory.setName(name);
		optionalCategory.setProducts(products);
		return catRepo.save(optionalCategory);
		}
	//------------------------End Category Methods-----------------------//
}
