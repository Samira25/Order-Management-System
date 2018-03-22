package co.innoweb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {
    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    //welcome page
    @RequestMapping(value = {"/", "/welcome"})
    public String welcome(Map<String, Object> map) {
        map.put("message", this.message);
        return "welcome";
    }

    //service page
    @RequestMapping(value = "/service")
    public String service(Map<String, Object> map) {
        map.put("message", this.message);
        return "service";
    }
}
