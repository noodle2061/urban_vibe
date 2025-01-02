package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Comment;
import java.util.List;

public interface CommentDao {
    List<Comment> getList();
    Comment getById(Long id);
    Comment create(Comment comment);
    Comment update(Comment comment);
    void delete(Long id);

    List<Comment> getCommentsByProductId(Long productId);
    List<Comment> getCommentsByUserId(Long userId);
}