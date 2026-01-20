package application.usecase;

import java.math.BigDecimal;

import application.port.SaveOrderPort;
import application.port.SendNotificationPort;
import domain.model.Order;

public class RegularOrderUseCase extends ProcessOrderUseCase {

	public RegularOrderUseCase(
			final SaveOrderPort orderPort, 
			final SendNotificationPort notificationPort) {
		super(orderPort, notificationPort);
	}

	@Override
	protected BigDecimal calculateTotal(
			final Order order) {
		return order.itemsTotal();
	}

	@Override
	protected void notifyCustomer(
			final Order order) {
		String message = "Your order has deen processed successfull";
		getNotificationPort().send(order.getCustomerMail(), message);
	}

}
