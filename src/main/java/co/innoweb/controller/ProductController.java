package co.innoweb.controller;

import co.innoweb.Service.ProductService;
import co.innoweb.model.Product;
import co.innoweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ProductController {
    @Autowired private ProductRepository productRepository;
    @Autowired private ProductService productService;

    //add new product via service page
    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String add(Map<String, Object> map, @ModelAttribute("addproduct") Product addproduct) {
        return "addproduct";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String addnew(@ModelAttribute("addproduct") Product addproduct) {
        productService.save(addproduct);
        return "service";
    }

    //see all product via service page
    @RequestMapping(value = "/viewallproduct", method = RequestMethod.GET)
    public String list(Map<String, Object> map) {
        map.put("productlist", productService.productlist());
        return "viewallproduct";
    }

    //edit product
    @RequestMapping(value = "/editproduct/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Map<String, Object> map,
                       @ModelAttribute("productedit")Product product) {
        Product pr =  productService.getById(id);
        map.put("productedit", pr);
        return "editproduct";
    }

    @RequestMapping(value = "/editproduct", method = RequestMethod.POST)
    public String update(@ModelAttribute("productedit") Product product, BindingResult result) {
        productService.update(product);
        return "service";
    }

    //delete order
    @RequestMapping(value = "/productdelete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return "viewallproduct";
    }

    //detail of single order
    @RequestMapping(value = "/detailproduct/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Map<String, Object> map,
                         @ModelAttribute("detailproduct")Product product) {
        Product pr = productService.getById(id);
        map.put("detailproduct", pr);
        return "detailproduct";
    }

}
