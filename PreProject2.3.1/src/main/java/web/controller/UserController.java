package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.model.User;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserDAO userDAOImpl;

    @Autowired
    public UserController(web.dao.UserDAOImpl UserDAOImpl) {
        this.userDAOImpl = UserDAOImpl;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDAOImpl.index());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userDAOImpl.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDAOImpl.show(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDAOImpl.update(id, user);
        return "redirect:/";
    }

}
