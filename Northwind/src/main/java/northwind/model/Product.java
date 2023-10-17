package northwind.model;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name = "northwind.product")
public class Product {
	private int _productID;
	private String _productName;
	private Supplier _supplier;
	private Category _category;
	private String _quantityPerUnit;
	private BigDecimal _unitPrice;
	private int _unitsInStock;
	private int _unitsOnOrder;
	private int _reorderLevel;
	private boolean _discontinued;
	private List<OrderDetail> _corrOrderDetails;

	@Id
	@NotNull
	@Column(name = "product_id")
	public int getProductID() {
		return _productID;
	}
	public void setProductID(int productID) {
		_productID = productID;
	}

	@NotNull
	@Column(name = "product_name")
	public String getProductName() {
		return _productName;
	}
	public void setProductName(String productName) {
		_productName = productName;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	public Supplier getSupplier() {
		return _supplier;
	}
	public void setSupplier(Supplier supplier) {
		_supplier = supplier;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return _category;
	}
	public void setCategory(Category category) {
		_category = category;
	}

	@Column(name = "quantity_per_unit")
	public String getQuantityPerUnit() {
		return _quantityPerUnit;
	}
	public void setQuantityPerUnit(String quantityPerUnit) {
		_quantityPerUnit = quantityPerUnit;
	}

	@NotNull
	@Column(name = "unit_price")
	public BigDecimal getUnitPrice() {
		return _unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		_unitPrice = unitPrice;
	}

	@NotNull
	@Column(name = "units_in_stock")
	public int getUnitsInStock() {
		return _unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		_unitsInStock = unitsInStock;
	}

	@NotNull
	@Column(name = "units_on_order")
	public int getUnitsOnOrder() {
		return _unitsOnOrder;
	}
	public void setUnitsOnOrder(int unitsOnOrder) {
		_unitsOnOrder = unitsOnOrder;
	}

	@NotNull
	@Column(name = "reorder_level")
	public int getReorderLevel() {
		return _reorderLevel;
	}
	public void setReorderLevel(int reorderLevel) {
		_reorderLevel = reorderLevel;
	}

	@NotNull
	@Column(name = "discontinued")
	public boolean isDiscontinued() {
		return _discontinued;
	}
	public void setDiscontinued(boolean discontinued) {
		_discontinued = discontinued;
	}
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	public List<OrderDetail> getCorrOrderDetails() {
		return _corrOrderDetails;
	}
	public void setCorrOrderDetails(List<OrderDetail> corrOrderDetails) {
		_corrOrderDetails = corrOrderDetails;
	}
}	
