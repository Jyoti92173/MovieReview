package com.app.MovieReview.repository;

import com.app.MovieReview.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    Double getReviewAverage(Long movieId);

}
