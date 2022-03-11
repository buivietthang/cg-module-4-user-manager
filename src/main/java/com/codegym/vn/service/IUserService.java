package com.codegym.vn.service;

import com.codegym.vn.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface IUserService {
    public List<User> findAll();

    public Page<User> findAll(Pageable pageable);

    public void save(User user);

    public void delete(long id);

    public User findById(long id);

    public ArrayList<User> findByName(String name);

    public List<User> sortByName();
}
