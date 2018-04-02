package co.innoweb.controller;

import co.innoweb.Service.User_roleService;
import co.innoweb.repository.User_roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

@Controller
public class User_roleController {
    @Autowired private User_roleRepository user_roleRepository;
    @Autowired private User_roleService user_roleService;

    //see all user via service page
    @RequestMapping(value = "/viewalluser_role", method = RequestMethod.GET)
    public String list(Map<String, Object> map) {
        map.put("user_rolelist", user_roleService.user_rolelist());
        return "viewalluser_role";
    }
}
