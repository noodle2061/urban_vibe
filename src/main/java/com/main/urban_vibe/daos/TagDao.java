package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Tag;
import java.util.List;

public interface TagDao {
    List<Tag> getList();
    Tag getById(Long id);
    Tag create(Tag tag);
    Tag update(Tag tag);
    void delete(Long id);

    Tag findByName(String name);
}