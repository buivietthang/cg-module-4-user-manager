package com.codegym.vn.validate;

import com.codegym.vn.model.User;
import com.codegym.vn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class ValidateName implements Validator {
    @Autowired
    IUserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        List<User> users = userService.findAll();
        for (User user1 : users) {
            if (user.getUsername().equals(user1.getUsername()) && (user1.getId() != user.getId())) {
                errors.rejectValue("username", "", "Username đã tồn tại");
            }
        }
    }
}
