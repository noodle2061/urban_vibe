package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.User;
import java.util.List;

public interface UserDao {
    List<User> getList();
    User getById(Long id);
    User create(User user);
    User update(User user);
    void delete(Long id);

    User findByEmail(String email);
    List<User> findByRole(String roleName);
}