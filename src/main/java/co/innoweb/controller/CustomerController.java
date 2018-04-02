package co.innoweb.controller;

import co.innoweb.Service.CustomerService;
import co.innoweb.model.Customer;
import co.innoweb.model.Order;
import co.innoweb.model.Role;
import co.innoweb.model.User_role;
import co.innoweb.repository.CustomerRepository;
import co.innoweb.repository.OrderRepository;
import co.innoweb.repository.RoleRepository;
import co.innoweb.repository.User_roleRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private CustomerService customerService;
    @Autowired private RoleRepository roleRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private User_roleRepository userRoleRepository;

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    //register
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Map<String, Object> map, @ModelAttribute("register") Customer register) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String success(@ModelAttribute("register") Customer register) {
        Role admin = roleRepository.findOne(1L);
        //Role role = roleRepository.findOne(2L);
        Customer customer = customerService.save(register);
        User_role user_role = new User_role();
        user_role.setRole(admin);
        user_role.setCustomer(customer);
        userRoleRepository.save(user_role);
        Order order = new Order();
        order.setCustomer_id(customer);
        orderRepository.save(order);
        return "service";
    }

    //login
    @RequestMapping(value = "/login")
    public String login(Map<String, Object> map, @ModelAttribute("login") Customer login) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map, @ModelAttribute("login") Customer login, BindingResult result) {
        Customer customer = customerService.login(login.getUsername(), login.getPassword(),request);
        Customer c=(Customer) request.getSession().getAttribute("user");
        System.out.println(c.toString());
        if (customer == null) {
            return "login";
        } else {
            map.put("message", this.message);
            return "welcome";
        }
    }

    //see all user via service page
    @RequestMapping(value = "/viewalluser", method = RequestMethod.GET)
    public String list(Map<String, Object> map) {
        map.put("userlist", customerService.list());
        return "viewalluser";
    }

    //edit user
    @RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Map<String, Object> map,
                       @ModelAttribute("useredit")Customer customer) {
        Customer c =  customerService.getById(id);
        map.put("useredit", c);
        return "edituser";
    }

    @RequestMapping(value = "/edituser", method = RequestMethod.POST)
    public String update(@ModelAttribute("useredit") Customer customer, BindingResult result) {
        customerService.update(customer);
        return "service";
    }

    //delete order
    @RequestMapping(value = "/userdelete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        customerService.delete(id);
        return "viewalluser";
    }

    //detail of single user
    @RequestMapping(value = "/detailuser/{id}", method = RequestMethod.GET)
    public String detailuser(@PathVariable("id") Long id, Map<String, Object> map,
                            @ModelAttribute("detailuser")Customer customer) {
        Customer c = customerService.getById(id);
        map.put("detailuser", c);
        return "detailuser";
    }
}