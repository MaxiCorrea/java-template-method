package application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import application.port.SaveOrderPort;
import application.port.SendNotificationPort;
import domain.model.Order;

class RegularOrderUseCaseTest {

	@Test
	void shouldProcessRegularSuccessfully() {
		SaveOrderPort saveOrder = Mockito.mock(SaveOrderPort.class);
		SendNotificationPort notificationOrder = Mockito.mock(SendNotificationPort.class);
		RegularOrderUseCase usecase = new RegularOrderUseCase(saveOrder, notificationOrder);
		Order order = OrderMother.createOrder();
		usecase.process(order);
		Mockito.verify(saveOrder).save(order);
		Mockito.verify(notificationOrder).send(Mockito.eq("maxi.com"), Mockito.contains("processed"));
		assertEquals(new BigDecimal("40"), order.getTotal());
	}

}
