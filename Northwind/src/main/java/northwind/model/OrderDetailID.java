package northwind.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class OrderDetailID implements Serializable {
	private static final long serialVersionUID = 1L;
	private Product _product;
    private Order _order;
	
    public Product getProduct() {
		return _product;
	}
	public void setProduct(Product product) {
		_product = product;
	}
	
	public Order getOrder() {
		return _order;
	}
	public void setOrder(Order order) {
		_order = order;
	}
    
	
}
