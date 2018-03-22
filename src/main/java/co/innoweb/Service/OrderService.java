package co.innoweb.Service;

import co.innoweb.model.Order;

import java.util.List;

public interface OrderService {
    public void save(Order order);
    public Order getById(long id);
    public Order update(Order order);
    public void delete(long id);
    public List<Order> orderlist();
}
