package domain.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {

	private final String customerEmail;
	private final List<OrderItem> items;
	private BigDecimal total;
	
	public Order(
			final String customerEmail,
			final List<OrderItem> items) {
		this.customerEmail = customerEmail;
		this.items = List.copyOf(items);
	}
	
	public void confirm(
			final BigDecimal total) {
		this.total = total;
	}
	
	public BigDecimal itemsTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for(OrderItem item : this.items) 
			total = total.add(item.price());
		return total;
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	public String getCustomerMail() {
		return customerEmail;
	}
	
	public BigDecimal getTotal() {
		return total;
	}

}
