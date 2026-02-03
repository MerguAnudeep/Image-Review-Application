package com.example.demo.outfit;

import com.example.demo.outfitImage.OutfitImage;
import com.example.demo.registerLogin.UserDetails;
import com.example.demo.review.Review_Duplicate;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Outfit {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String outfitLink;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetails user;

    @OneToMany(mappedBy = "outfit", cascade = CascadeType.ALL)
    private List<OutfitImage> images;

    @OneToMany(mappedBy = "outfit", cascade = CascadeType.ALL)
    private List<Review_Duplicate> reviews;

    // getters and setters
    public Outfit(){

    }
    public Outfit(String outfitLink, UserDetails user, List<OutfitImage> images, List<Review_Duplicate> reviews) {
        this.outfitLink = outfitLink;
        this.user = user;
        this.images = images;
        this.reviews = reviews;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutfitLink() {
        return outfitLink;
    }

    public void setOutfitLink(String outfitLink) {
        this.outfitLink = outfitLink;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public List<OutfitImage> getImages() {
        return images;
    }

    public void setImages(List<OutfitImage> images) {
        this.images = images;
    }

    public List<Review_Duplicate> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review_Duplicate> reviews) {
        this.reviews = reviews;
    }
}

