package com.example.demo.outfit;

public class OutfitGalleryResponse {

    private Long outfitId;
    private String fileType;
    private String imageData;
    private String outfitLink;

    public OutfitGalleryResponse(Long outfitId,
                                 String fileType,
                                 String imageData,
                                 String outfitLink) {
        this.outfitId = outfitId;
        this.fileType = fileType;
        this.imageData = imageData;
        this.outfitLink = outfitLink;
    }

    public Long getOutfitId() { return outfitId; }
    public String getFileType() { return fileType; }
    public String getImageData() { return imageData; }
    public String getOutfitLink() { return outfitLink; }
}

