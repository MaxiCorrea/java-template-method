package application.usecase;

import java.math.BigDecimal;

import application.port.SaveOrderPort;
import application.port.SendNotificationPort;
import domain.model.Order;

public abstract class ProcessOrderUseCase {

	private final SaveOrderPort orderPort;
	private final SendNotificationPort notificationPort;
	
	public ProcessOrderUseCase(
			final SaveOrderPort orderPort,
			final SendNotificationPort notificationPort) {
		this.orderPort = orderPort;
		this.notificationPort = notificationPort;
	}
	
	public final void process(
			final Order order) {
		validate(order);
		BigDecimal total = calculateTotal(order);
		order.confirm(total);
		persist(order);
		notifyCustomer(order);
	}

	public SendNotificationPort getNotificationPort() {
		return notificationPort;
	}
	
	private void validate(
			final Order order) {
		if(order.isEmpty()) {
			throw new IllegalArgumentException("Order must have items.");
		}
	}

	private void persist(
			final Order order) {
		this.orderPort.save(order);
	}
	
	protected abstract BigDecimal calculateTotal(Order order);
	
	protected abstract void notifyCustomer(Order order);
	
}
