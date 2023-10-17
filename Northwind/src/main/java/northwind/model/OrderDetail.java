package northwind.model;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@IdClass(OrderDetailID.class)
@Table(name = "northwind.order_detail")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private Product _product;
	private Order _order;
    private BigDecimal _UnitPrice;
    private int _quantity;
    private BigDecimal _discount;
    
    @Id
    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product getProduct() {
    	return _product;
    }
    public void setProduct(Product product) {
    	_product = product;
    }

	@Id
	@NotNull
	@ManyToOne
	@JoinColumn(name = "order_id")
	public Order getOrder() {
		return _order;
	}
	public void setOrder(Order order) {
		_order = order;
	}

	@NotNull
	@Column(name = "unit_price")
	public BigDecimal getUnitPrice() {
        return _UnitPrice;
    }
	public void setUnitPrice(BigDecimal unitPrice) {
        _UnitPrice = unitPrice;
    }
	
	@NotNull
	@Column(name = "quantity")
    public int getQuantity() {
        return _quantity;
    }
    public void setQuantity(int quantity) {
        _quantity = quantity;
    }

    @NotNull
    @Column(name = "discount")
    public BigDecimal getDiscount() {
        return _discount;
    }
    public void setDiscount(BigDecimal discount) {
        _discount = discount;
    }
}
