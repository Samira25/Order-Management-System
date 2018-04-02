package co.innoweb.Service;

import co.innoweb.model.Customer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CustomerService {
    public Customer save(Customer customer);
    public Customer getById(long id);
    public Customer update(Customer customer);
    public void delete(long id);
    public List<Customer> list();
    public Customer login(String username, String password, HttpServletRequest request);
}
