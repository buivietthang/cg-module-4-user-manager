package com.codegym.vn.repository;

import com.codegym.vn.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepo extends PagingAndSortingRepository<Role, Long> {
}
