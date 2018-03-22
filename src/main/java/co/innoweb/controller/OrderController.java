package co.innoweb.controller;

import co.innoweb.Service.OrderService;
import co.innoweb.model.Order;
import co.innoweb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class OrderController {
    @Autowired private OrderRepository orderRepository;
    @Autowired private OrderService orderService;

    //add new order via service page
    @RequestMapping(value = "/addorder", method = RequestMethod.GET)
    public String add(Map<String, Object> map, @ModelAttribute("addorder")Order addorder) {
        return "addorder";
    }

    @RequestMapping(value = "/addorder", method = RequestMethod.POST)
    public String addnew(@ModelAttribute("addorder")Order addorder) {
        orderService.save(addorder);
        return "service";
    }

    //see all order via service page
    @RequestMapping(value = "/viewallorder", method = RequestMethod.GET)
    public String list(Map<String, Object> map) {
        map.put("orderlist", orderService.orderlist());
        return "viewallorder";
    }

    //edit order
    @RequestMapping(value = "/editorder/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Map<String, Object> map,
                       @ModelAttribute("orderedit")Order order) {
        Order ord =  orderService.getById(id);
        map.put("orderedit", ord);
        return "editorder";
    }

    @RequestMapping(value = "/editorder", method = RequestMethod.POST)
    public String update(@ModelAttribute("orderedit") Order order, BindingResult result) {
        orderService.update(order);
        return "service";
    }

    //delete order
    @RequestMapping(value = "/orderdelete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        orderService.delete(id);
        return "viewallorder";
    }

    //detail of single order
    @RequestMapping(value = "/detailorder/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Map<String, Object> map,
                            @ModelAttribute("detailorder")Order order) {
        Order ord = orderService.getById(id);
        map.put("detailorder", ord);
        return "detailorder";
    }

}
