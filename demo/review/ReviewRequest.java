package com.example.demo.review;

public class ReviewRequest {
    private String comment;
    private Long outfitId;
    private String email;
    public ReviewRequest(String comment, Long outfitId, String email) {
        this.comment = comment;
        this.outfitId = outfitId;
        this.email = email;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getOutfitId() {
        return outfitId;
    }

    public void setOutfitId(Long imageId) {
        this.outfitId = outfitId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // getters and setters
}

