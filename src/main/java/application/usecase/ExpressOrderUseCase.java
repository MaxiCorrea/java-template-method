package application.usecase;

import java.math.BigDecimal;

import application.port.SaveOrderPort;
import application.port.SendNotificationPort;
import domain.model.Order;

public class ExpressOrderUseCase extends ProcessOrderUseCase {

	private static final BigDecimal EXPRESS_FEE = new BigDecimal("15.00");
	
	public ExpressOrderUseCase(
			final SaveOrderPort orderPort, 
			final SendNotificationPort notificationPort) {
		super(orderPort, notificationPort);
	}

	@Override
	protected BigDecimal calculateTotal(
			final Order order) {
		return order.itemsTotal().add(EXPRESS_FEE);
	}

	@Override
	protected void notifyCustomer(
			final Order order) {
		String message = "Yout EXPRESS has been precessed";
		getNotificationPort().send(order.getCustomerMail(), message);
	}

}
