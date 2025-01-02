package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Feedback;
import java.util.List;

public interface FeedbackDao {
    List<Feedback> getList();
    Feedback getById(Long id);
    Feedback create(Feedback feedback);
    Feedback update(Feedback feedback);
    void delete(Long id);

    List<Feedback> getFeedbacksByProductId(Long productId);
    List<Feedback> getFeedbacksByUserId(Long userId);
    List<Feedback> getFeedbacksByStatus(String status);
}