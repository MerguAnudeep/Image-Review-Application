package com.example.demo.review;

import com.example.demo.outfit.Outfit;
import com.example.demo.outfit.OutfitRepository;
import com.example.demo.registerLogin.UserDetails;
import com.example.demo.registerLogin.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OutfitRepository outfitRepository;

    // 🔹 Add a review for an outfit
    public void addReview(String comment, Long outfitId, String email) {

        UserDetails user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Outfit outfit = outfitRepository.findById(outfitId)
                .orElseThrow(() -> new RuntimeException("Outfit not found"));

        Review_Duplicate review = new Review_Duplicate();
        review.setComment(comment);
        review.setUserdetails(user);
        review.setOutfit(outfit);

        reviewRepository.save(review);
    }

    // 🔹 Fetch all reviews of an outfit
    @Transactional
    public List<ReviewResponse> getReviewsByOutfit(Long outfitId) {

        List<Review_Duplicate> reviews = reviewRepository.findByOutfitId(outfitId);

        return reviews.stream()
                .map(r -> new ReviewResponse(
                        r.getUserdetails() != null
                                ? r.getUserdetails().getUserName()
                                : "Anonymous",
                        r.getComment()
                ))
                .toList();
    }
}

