package com.example.demo;
import com.example.demo.outfit.OutfitDetailsResponse;
import com.example.demo.outfit.OutfitGalleryResponse;
import com.example.demo.outfit.OutfitService;
import com.example.demo.registerLogin.Login;
import com.example.demo.registerLogin.LoginService;
import com.example.demo.review.ReviewRequest;
import com.example.demo.review.ReviewResponse;
import com.example.demo.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private OutfitService outfitService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/upload")
    public String uploadOutfit(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam String email,
            @RequestParam String outfitLink
    ) throws IOException {

        System.out.println("Uploading outfit for: " + email);
        outfitService.uploadOutfit(files, email, outfitLink);
        return "Outfit uploaded successfully";
    }

    @GetMapping("/gallery")
    public List<OutfitGalleryResponse> getGallery() {
        return outfitService.getOutfitsForGallery();
    }

    @GetMapping("/outfit/{id}")
    public OutfitDetailsResponse getOutfit(@PathVariable Long id) {
        return outfitService.getOutfitDetails(id);
    }

    @PostMapping("/Login")
    public ResponseEntity<String> userLogin(@RequestBody Login login) {
        return ResponseEntity.ok(loginService.userLogin(login));
    }

    @GetMapping("/reviews/{outfitId}")
    public List<ReviewResponse> getReviews(@PathVariable Long outfitId) {
        return reviewService.getReviewsByOutfit(outfitId);
    }

    @PostMapping("/add")
    public String addReview(@RequestBody ReviewRequest request) {

        reviewService.addReview(
                request.getComment(),
                request.getOutfitId(),
                request.getEmail()
        );
        System.out.println("REview Added");
        System.out.println( request.getComment());
        return "Review added";
    }
    @GetMapping("/Greet")
    public String  m(){
        return "Hai buddy";
    }
}

/*
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller {
       @Autowired
       private ReviewService reviewService;
    @Autowired
    OutfitService outfitService;
    @Autowired
    LoginService loginService;
    @PostMapping("/upload")
    public String uploadOutfit(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam String email,
            @RequestParam String outfitLink
    ) throws IOException {
        System.out.println(email);
        outfitService.uploadOutfit(files, email, outfitLink);
        return "Outfit uploaded successfully";
    }
    @GetMapping("/gallery")
    public List<OutfitGalleryResponse> getGallery() {
        return outfitService.getOutfitsForGallery();
    }
    @GetMapping("/outfit/{id}")
    public OutfitDetailsResponse getOutfit(@PathVariable Long id) {
        return outfitService.getOutfitDetails(id);
    }

    @PostMapping("/Login")
    public ResponseEntity<String> userLogin(@RequestBody Login login){
        String str=loginService.userLogin(login);
        System.out.println(str);
        return ResponseEntity.ok(str);
    }
    @GetMapping("/{imageId}")
    //@GetMapping("/reviews/{imageId}")
    public List<ReviewResponse> getReviews(@PathVariable Long imageId) {
        return reviewService.getReviewsByOutfit(imageId);
    }
    //
    @PostMapping("/add")
    public String addReview(@RequestBody ReviewRequest request) {
        reviewService.addReview(
                request.getComment(),
                request.getImageId(),
                request.getEmail()
        );
        return "Review added";
    }
*/


//    @Autowired
//    LoginService service;
    //    @Autowired
//    ImageService imageservice;

//    @PostMapping("/map")
//    public String m1(@RequestBody UserDetails userDetails){
//        //System.out.println("User Mobile number"+userDetails.getMobile_no());
//        return service.addDetails(userDetails);
//    }
//    @PostMapping("/upload")
//    public String uploadImage(
//            @RequestParam MultipartFile file,
//            @RequestParam String email,
//            @RequestParam String outfitLink) throws IOException {
//
//        imageservice.uploadImage(file, email, outfitLink);
//        return "Image uploaded successfully";
//    }
//    @GetMapping("/all")
//    public List<ImageResponse> getAllImages(){
//        return imageservice.getAllImages();
//    }
//
//
//    @PostMapping("/Login")
//    public ResponseEntity<String> userLogin(@RequestBody Login login){
//        String str=service.userLogin(login);
//        System.out.println(str);
//        return ResponseEntity.ok(str);
//    }
//    @GetMapping("/image/{imageId}")
//    public ImageResponse getImageById(@PathVariable Long imageId) {
//
//        return imageservice.getImageById(imageId);
 //   }

//


//    @GetMapping("/{imageId}")
//    public List<Review> getReviews(@PathVariable Long imageId) {
//        return reviewService.getReviewsByImage(imageId);
    //  }
    //@GetMapping("/all")
//public List<ImageResponse> getImages(
//        @RequestParam int page,
//        @RequestParam int size) {
//
//    return imageservice.getImagesWithPagination(page, size);
//}


