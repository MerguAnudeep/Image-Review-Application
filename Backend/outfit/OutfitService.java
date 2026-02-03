package com.example.demo.outfit;
import com.example.demo.outfitImage.OutfitImage;
import com.example.demo.outfitImage.OutfitImageRepository;
import com.example.demo.registerLogin.UserDetails;
import com.example.demo.registerLogin.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class OutfitService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OutfitRepository outfitRepository;

    @Autowired
    private OutfitImageRepository outfitImageRepository;

    public void uploadOutfit(
            MultipartFile[] files,
            String email,
            String outfitLink
    ) throws IOException {

        // 1️⃣ Find user
        UserDetails user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2️⃣ Create Outfit
        Outfit outfit = new Outfit();
        outfit.setOutfitLink(outfitLink);
        outfit.setUser(user);

        // Save outfit first (IMPORTANT)
        Outfit savedOutfit = outfitRepository.save(outfit);

        // 3️⃣ Save each image
        for (MultipartFile file : files) {

            OutfitImage image = new OutfitImage();
            image.setFileType(file.getContentType());
            image.setImageData(file.getBytes());
            image.setOutfit(savedOutfit);

            outfitImageRepository.save(image);
        }
    }
    public List<OutfitGalleryResponse> getOutfitsForGallery() {

        List<Outfit> outfits = outfitRepository.findAll();
        List<OutfitGalleryResponse> response = new ArrayList<>();

        for (Outfit outfit : outfits) {

            if (outfit.getImages() == null || outfit.getImages().isEmpty()) {
                continue;
            }

            OutfitImage firstImage = outfit.getImages().get(0);
            String base64 = Base64.getEncoder()
                    .encodeToString(firstImage.getImageData());

            response.add(new OutfitGalleryResponse(
                    outfit.getId(),
                    firstImage.getFileType(),
                    base64,
                    outfit.getOutfitLink()
            ));
        }
        return response;
    }
    public OutfitDetailsResponse getOutfitDetails(Long outfitId) {

        Outfit outfit = outfitRepository.findById(outfitId)
                .orElseThrow(() -> new RuntimeException("Outfit not found"));

        List<ImageDto> imageDtos = new ArrayList<>();

        for (OutfitImage img : outfit.getImages()) {
            String base64 = Base64.getEncoder()
                    .encodeToString(img.getImageData());

            imageDtos.add(new ImageDto(
                    img.getFileType(),
                    base64
            ));
        }

        return new OutfitDetailsResponse(
                outfit.getId(),
                outfit.getOutfitLink(),
                imageDtos
        );
    }

}

