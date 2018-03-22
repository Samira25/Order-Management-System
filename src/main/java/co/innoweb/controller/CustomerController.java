package co.innoweb.controller;

import co.innoweb.Service.CustomerService;
import co.innoweb.model.Customer;
import co.innoweb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class CustomerController {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private CustomerService customerService;

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    //register
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Map<String, Object> map, @ModelAttribute("register") Customer register) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String success(@ModelAttribute("register") Customer register) {
        customerService.save(register);
        return "service";
    }

    //login
    @RequestMapping(value = "/login")
    public String login(Map<String, Object> map, @ModelAttribute("login") Customer login) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Map<String, Object> map, @ModelAttribute("login") Customer login, BindingResult result) {
        Customer customer = customerService.login(login.getUsername(), login.getPassword());
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