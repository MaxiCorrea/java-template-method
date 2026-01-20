package application.usecase;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import application.port.SaveOrderPort;
import application.port.SendNotificationPort;
import domain.model.Order;

class ExpressOrderUseCaseTest {

	@Test
	void shouldProcessExpressSuccessfully() {
		SaveOrderPort saveOrder = Mockito.mock(SaveOrderPort.class);
		SendNotificationPort notificationOrder = Mockito.mock(SendNotificationPort.class);
		ExpressOrderUseCase usecase = new ExpressOrderUseCase(saveOrder, notificationOrder);
		Order order = OrderMother.createOrder();
		usecase.process(order);
		Mockito.verify(saveOrder).save(order);
		Mockito.verify(notificationOrder).send(Mockito.eq("maxi.com"), Mockito.contains("EXPRESS"));
		assertEquals(new BigDecimal("55.00"), order.getTotal());
	}

}
