package com.adamp.productscategories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Size(min = 2, message = "Must be at least 2 characters") @Size(max = 255, message = "Cannot exceed 255 characters")
    private String name;
	@Size(min = 2, message = "Must be at least 2 characters") @Size(max = 255, message = "Cannot exceed 255 characters")
    private String description;
	@NotNull(message="Must enter a price")
    private float price;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
	// Many to Many Relationship	*Remember to Set getters and setters after adding relationships
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    
    
    private List<Category> categories;

    
	//always add an empty constructor
    public Product() {
    }
    
	public Product(Long id,
			@Size(min = 2, message = "Must be at least 2 characters") @Size(max = 255, message = "Cannot exceed 255 characters") String name,
			@Size(min = 2, message = "Must be at least 2 characters") @Size(max = 255, message = "Cannot exceed 255 characters") String description,
			@NotNull(message = "Must enter a price") float price, List<Category> categories) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categories = categories;
	}

	//Remember to always add these two
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
    }
	
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	//	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
}