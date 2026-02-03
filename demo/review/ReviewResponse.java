package com.example.demo.review;

public class ReviewResponse {
    private String userName;
    private String comment;


    public ReviewResponse(String userName, String comment) {
        this.userName = userName;
        this.comment = comment;
    }
//    public String getOutfitLink() {
//        return outfitLink;
//    }
//
//    public void setOutfitLink(String outfitLink) {
//        this.outfitLink = outfitLink;
 //   }
    public String getUserName() {
        return userName;
    }

    public String getComment() {
        return comment;
    }
}

