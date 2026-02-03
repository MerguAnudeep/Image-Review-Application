package com.example.demo.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//
//public interface ReviewRepository extends JpaRepository<Review_Duplicate, Long> {
//
//    // get all reviews for a specific image
//    List<Review_Duplicate> findByImageId(Long imageId);
//}


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review_Duplicate, Long> {

    List<Review_Duplicate> findByOutfitId(Long outfitId);
}
