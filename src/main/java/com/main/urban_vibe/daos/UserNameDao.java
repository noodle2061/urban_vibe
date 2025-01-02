package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.UserName;
import java.util.List;

public interface UserNameDao {
    List<UserName> getList();
    UserName getById(Long id);
    UserName create(UserName userName);
    UserName update(UserName userName);
    void delete(Long id);

    UserName findByUserId(Long userId);
    UserName findByFullName(String fullName);
}