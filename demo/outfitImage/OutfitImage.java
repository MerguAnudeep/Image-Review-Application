package com.example.demo.outfitImage;

import com.example.demo.outfit.Outfit;
import jakarta.persistence.*;

@Entity
public class OutfitImage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;

    private String fileType;

    @ManyToOne
    @JoinColumn(name = "outfit_id")
    private Outfit outfit;
    public OutfitImage(){

    }
    OutfitImage(byte[] imageData, String fileType, Outfit outfit) {
        this.imageData = imageData;
        this.fileType = fileType;
        this.outfit = outfit;
    }
    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

}

