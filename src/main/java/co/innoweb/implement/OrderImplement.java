package co.innoweb.implement;

import co.innoweb.Service.OrderService;
import co.innoweb.model.Customer;
import co.innoweb.model.Order;
import co.innoweb.model.Product;
import co.innoweb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service("OrderService")
public class OrderImplement implements OrderService {

    @Autowired private OrderService orderService;
    @Autowired private OrderRepository orderRepository;
    @Autowired private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;

    public OrderImplement(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order getById(long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order update(Order order) {
        Order o = orderRepository.findOne(order.getId());
        o.setCustomer_id(order.getCustomer_id());
        o.setProduct_id(order.getProduct_id());
        o.setQuantity(order.getQuantity());
        o.setTotal_price(order.getTotal_price());
        o.setDelivery_date(order.getDelivery_date());
        return orderRepository.save(o);
    }

    @Override
    public void delete(long id) {
        Order order = orderRepository.findOne(id);
        orderRepository.delete(order);
    }

    @Override
    public List<Order> orderlist() {
        String sql = "select * from customer_order";
        List<Order> orderList = jdbcTemplate.query(sql, new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                Order order = new Order();
                order.setId(resultSet.getLong("id"));
                order.setQuantity(resultSet.getInt("quantity"));
                order.setCustomer_id((Customer) resultSet.getArray("id"));
                order.setProduct_id((Product) resultSet.getArray("id"));
                order.setTotal_price(resultSet.getDouble("total_price"));
                order.setDelivery_date(resultSet.getDate("delivery_date"));
                return order;
            }
        });
        return orderList;
    }
}
