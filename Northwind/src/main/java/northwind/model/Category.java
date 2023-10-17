package northwind.model;

import java.util.List;

import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name = "northwind.categorie")
public class Category {
	private int _categoryID;
	private String _categoryName;
	private String _description;
	private String _picture;
	private List<Product> _products;
	
	@Id
	@NotNull
	@Column(name = "category_id")
	public int getCategoryID() {
		return _categoryID;
	}
	public void setCategoryID(int categoryID) {
		_categoryID = categoryID;
	}
	
	@NotNull
	@Column(name = "category_name")
	public String getCategoryName() {
		return _categoryName;
	}
	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return _description;
	}
	public void setDescription(String description) {
		_description = description;
	}
	
	@Column(name = "picture")
	public String getPicture() {
		return _picture;
	}
	public void setPicture(String picture) {
		_picture = picture;
	}

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	public List<Product> getProducts() {
		return _products;
	}
	public void setProducts(List<Product> products) {
		_products = products;
	}
}
