package com.example.demo.review;
import com.example.demo.outfit.Outfit;
import com.example.demo.registerLogin.UserDetails;
import jakarta.persistence.*;

@Entity
public class Review_Duplicate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "outfit_id")
    private Outfit outfit;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetails userdetails;
    public Review_Duplicate(){

    }
    public Review_Duplicate(String comment, Outfit outfit, UserDetails userdetails) {
        this.comment = comment;
        this.outfit = outfit;
        this.userdetails = userdetails;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    public UserDetails getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(UserDetails userdetails) {
        this.userdetails = userdetails;
    }

}

