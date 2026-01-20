package application.port;

import domain.model.Order;

public interface SaveOrderPort {

	void save(Order order);

}
