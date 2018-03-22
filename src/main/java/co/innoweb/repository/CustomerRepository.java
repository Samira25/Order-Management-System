package co.innoweb.repository;

import co.innoweb.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query("select customer from Customer customer where customer.username = :username and customer.password = :password")
    Customer login(@Param("username") String username, @Param("password") String password);
}