package co.innoweb.controller;

import co.innoweb.Service.RoleService;
import co.innoweb.model.Role;
import co.innoweb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

@Controller
public class RoleController {
    @Autowired private RoleRepository roleRepository;
    @Autowired private RoleService roleService;

    //add new role via service page
    @RequestMapping(value = "/addrole", method = RequestMethod.GET)
    public String add(Map<String, Object> map, @ModelAttribute("addrole") Role addrole) {
        return "addrole";
    }

    @RequestMapping(value = "/addrole", method = RequestMethod.POST)
    public String addnew(@ModelAttribute("addrole") Role addrole) {
        roleService.save(addrole);
        return "service";
    }

    //see all role via service page
    @RequestMapping(value = "/viewallrole", method = RequestMethod.GET)
    public String list(Map<String, Object> map) {
        map.put("rolelist", roleService.rolelist());
        return "viewallrole";
    }

    //edit role
    @RequestMapping(value = "/editrole/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Map<String, Object> map,
                       @ModelAttribute("roleedit")Role role) {
        Role r =  roleService.getById(id);
        map.put("roleedit", r);
        return "editrole";
    }

    @RequestMapping(value = "/editrole", method = RequestMethod.POST)
    public String update(@ModelAttribute("roleedit") Role role, BindingResult result) {
        roleService.update(role);
        return "service";
    }

    //delete role
    @RequestMapping(value = "/roledelete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        roleService.delete(id);
        return "viewallrole";
    }

    //detail of single role
    @RequestMapping(value = "/detailrole/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Map<String, Object> map,
                         @ModelAttribute("detailrole")Role role) {
        Role r = roleService.getById(id);
        map.put("detailrole", r);
        return "detaileole";
    }

}
