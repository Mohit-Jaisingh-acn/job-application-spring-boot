package com.embark.jobapp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);
    Review getReview(Long companyId, Long reviewId);
    boolean addReview(Long companyId, Review review);
    boolean updateReview(Long companyId, Long reviewId, Review updatedReview);
    boolean deleteReview(Long companyId, Long reviewId);
}
