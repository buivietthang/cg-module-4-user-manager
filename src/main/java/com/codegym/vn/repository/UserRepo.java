package com.codegym.vn.repository;

import com.codegym.vn.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface UserRepo extends PagingAndSortingRepository<User, Long> {
    @Query(value = "select u from User u where u.username like concat('%' ,:name, '%')")
    ArrayList<User> findAllByName(@Param("name") String name);
}
