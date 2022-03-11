package com.codegym.vn.controller;

import com.codegym.vn.model.User;
import com.codegym.vn.service.IRoleService;
import com.codegym.vn.service.IUserService;
import com.codegym.vn.validate.ValidateName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;
    @Autowired
    ValidateName validateName;
    @Value("${uploadPart}")
    private String uploadPart;

    @GetMapping("/home")
    public ModelAndView showUser(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/showUser");
        modelAndView.addObject("user", userService.findAll(PageRequest.of(page, 4)));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("createUser");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

//    @PostMapping("create")
//    public Object add(@Valid @ModelAttribute(value = "user") User user, BindingResult bindingResult, @RequestParam MultipartFile upImg) {
//        validateName.validate(user, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            ModelAndView modelAndView = new ModelAndView("createUser");
//            return modelAndView;
//        }
//        String fileName = upImg.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(upImg.getBytes(), new File(uploadPart + "img/" + fileName));
//            user.setAvatar("img/" + fileName);
//            userService.save(user);
//        } catch (IOException e) {
//            user.setAvatar("https://vn.portal-pokemon.com/play/resources/pokedex/img/pm/8838c65ba52945317cda0d31f8de760860dd71ec.png");
//            userService.save(user);
//            e.printStackTrace();
//        }
//        return "redirect:/home";
//    }
}
