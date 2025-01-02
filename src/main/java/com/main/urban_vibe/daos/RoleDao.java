package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Role;
import java.util.List;

public interface RoleDao {
    List<Role> getList();
    Role getById(Long id);
    Role create(Role role);
    Role update(Role role);
    void delete(Long id);

    Role findByName(String name);
}