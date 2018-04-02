package co.innoweb.controller;

import co.innoweb.Service.OrderService;
import co.innoweb.model.Order;
import co.innoweb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired private OrderRepository orderRepository;
    @Autowired private OrderService orderService;

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

    @ResponseBody
    @RequestMapping(value = "/saveOrders", method = RequestMethod.GET)
    public String saveOrders(@Valid @RequestBody HttpServletRequest request, HttpServletResponse response, BindingResult result, Model model,
                             @RequestParam(value = "items")String []items, @RequestParam(value = "price")String []price) throws ServletException {
        System.out.println("------------------");
        System.out.println(result);
        System.out.println(Arrays.toString(items));
        System.out.println(Arrays.toString(price));
        System.out.println("------------------");
        return "saveOrders";
    }

}
