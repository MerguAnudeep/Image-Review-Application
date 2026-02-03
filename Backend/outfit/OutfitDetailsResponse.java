package com.example.demo.outfit;

import java.util.List;

public class OutfitDetailsResponse {

    private Long outfitId;
    private String outfitLink;
    private List<ImageDto> images;

    public OutfitDetailsResponse(Long outfitId,
                                 String outfitLink,
                                 List<ImageDto> images) {
        this.outfitId = outfitId;
        this.outfitLink = outfitLink;
        this.images = images;
    }

    public Long getOutfitId() { return outfitId; }
    public String getOutfitLink() { return outfitLink; }
    public List<ImageDto> getImages() { return images; }
}

