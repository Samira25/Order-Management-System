package co.innoweb.implement;

import co.innoweb.Service.CustomerService;
import co.innoweb.model.Customer;
import co.innoweb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service("customerService")
public class CustomerImplement implements CustomerService {

    @Autowired private CustomerService userService;
    @Autowired private CustomerRepository userRepository;
    @Autowired private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;

    public CustomerImplement(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Customer save(Customer customer) {
      return  userRepository.save(customer);
    }

    @Override
    public Customer getById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Customer update(Customer customer) {
        Customer c = new Customer();
        c.setName(customer.getName());
        c.setUsername(customer.getUsername());
        c.setPhone(customer.getPhone());
        c.setEmail(customer.getEmail());
        c.setPassword(customer.getPassword());
        return userRepository.save(c);
    }

    @Override
    public void delete(long id) {
        Customer customer = userRepository.findOne(id);
        userRepository.delete(customer);
    }

    @Override
    public List<Customer> list() {
        String sql = "select * from customer";
        List<Customer> customerList = jdbcTemplate.query(sql, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setUsername(resultSet.getString("username"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));
                return customer;
            }
        });
        return customerList;
    }

    @Override
    public Customer login(String username, String password, HttpServletRequest request) {
        Customer customer = userRepository.login(username, password);
        if (customer != null) {
            request.getSession().setAttribute("user",customer);
            return customer;
        }
        return null;
    }
}
