package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.project.model.User;
import web.project.service.UserService;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String welcomePrint(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }
    @GetMapping(value = "/add")
    public String showUserForm(ModelMap model) {
        model.put("Title","Add new user");
        User newUser = new User();
        model.put("user",newUser);
        return "add";
    }
    @PostMapping(value = "/add")
    public String addUserForm(@RequestParam String name, @RequestParam String surname,
                              @RequestParam int age, ModelMap model) {
        User newUser=new User(name,surname,age);
        userService.add(newUser);
        model.put("users",newUser);
        return "redirect:users";
    }
    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id", required = true, defaultValue = "") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
    @GetMapping(value = "/edit")
    public String showEditUserForm(@RequestParam Long id,ModelMap model) {
        model.addAttribute("user",userService.getUserById(id));
        model.put("Title","Edit user");
        return "add";
    }
    @PostMapping(value = "/edit")
    public String editUserForm(@RequestParam Long id,@RequestParam String name,@RequestParam String surname,
                              @RequestParam int age, ModelMap model) {
        User newUser=new User(name,surname,age);
        newUser.setId(id);
        userService.update(newUser);

        return "redirect:users";
    }
}
