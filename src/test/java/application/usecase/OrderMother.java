package application.usecase;

import java.math.BigDecimal;
import java.util.List;

import domain.model.Order;
import domain.model.OrderItem;

public class OrderMother {

	public static Order createOrder() {
		String customerMail = "maxi.com";
		Order order = new Order(customerMail,
				List.of(
						new OrderItem("item-1", BigDecimal.TEN), 
						new OrderItem("item-2", BigDecimal.TEN),
						new OrderItem("item-3", BigDecimal.TEN), 
						new OrderItem("item-4", BigDecimal.TEN)));
		return order;
	}

}
