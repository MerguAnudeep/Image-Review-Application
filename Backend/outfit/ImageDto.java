package com.example.demo.outfit;

public class ImageDto {
    private String fileType;
    private String imageData;

    public ImageDto(String fileType, String imageData) {
        this.fileType = fileType;
        this.imageData = imageData;
    }

    public String getFileType() { return fileType; }
    public String getImageData() { return imageData; }
}
