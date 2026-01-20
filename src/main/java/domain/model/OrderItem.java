package domain.model;

import java.math.BigDecimal;

public class OrderItem {

	private final String name;
	private final BigDecimal price;
	
	public OrderItem(
			String name,
			BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal price() {
		return price;
	}

}
