package com.embark.jobapp.review.impl;

import com.embark.jobapp.company.Company;
import com.embark.jobapp.company.CompanyRepository;
import com.embark.jobapp.company.CompanyService;
import com.embark.jobapp.review.Review;
import com.embark.jobapp.review.ReviewRepository;
import com.embark.jobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;
    CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId))
                .findFirst().orElse(null);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        Review review = getReview(companyId, reviewId);
        if(review != null){
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setTitle(updatedReview.getTitle());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        Review review = getReview(companyId, reviewId);
        if(review != null){
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
