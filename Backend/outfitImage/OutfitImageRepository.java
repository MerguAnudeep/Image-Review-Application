package com.example.demo.outfitImage;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OutfitImageRepository extends JpaRepository<OutfitImage, Long> {

    // Fetch all images of one outfit
    List<OutfitImage> findByOutfitId(Long outfitId);
}

