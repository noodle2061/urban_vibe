package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Rating;
import java.util.List;

public interface RatingDao {
    List<Rating> getList();
    Rating getById(Long id);
    Rating create(Rating rating);
    Rating update(Rating rating);
    void delete(Long id);

    List<Rating> getRatingsByProductId(Long productId);
    List<Rating> getRatingsByUserId(Long userId);
    Double getAverageRatingByProductId(Long productId);
}