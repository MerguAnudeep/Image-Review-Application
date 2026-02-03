# Image Review Portal

Outfit Review Portal is a full-stack web application that allows users to upload outfit images and receive feedback through comments and reviews.  
The platform helps users decide the best outfit for events by collecting opinions from others, similar to how product images and reviews work in fashion e-commerce applications.

---

## 📌 Project Overview

Many people rely on others’ opinions before selecting an outfit for an important event.  
This application provides an online solution where users can upload multiple images of an outfit and receive feedback from other users through comments and reviews.

---

## 🚀 Features

- User registration and login
- Upload outfits with multiple images
- Attach an outfit/product link with uploads
- View all outfits in a gallery view
- View outfit details with multiple images
- Add and view reviews for each outfit
- Works on both laptop and mobile devices
- REST API–based backend architecture

---

## 🛠️ Tech Stack

### Backend
- Java
- Spring Boot
- Spring Data JPA
- REST APIs
- MySQL

### Frontend
- HTML
- CSS
- JavaScript

---

## 🗄️ Database Design (High Level)

- **User** – stores user details (email, name, password, etc.)
- **Outfit** – represents a product/outfit uploaded by a user
- **Outfit Images** – stores multiple images for one outfit
- **Reviews** – stores comments given by users on outfits

Each outfit can have **multiple images**, and each outfit can have **multiple reviews**.

---

## 🔄 Application Flow

1. User registers and logs in
2. Logged-in user uploads an outfit with multiple images and an optional product link
3. Uploaded outfits appear in the gallery
4. Other users can open an outfit and view all its images
5. Users can add reviews/comments on the outfit
6. Reviews are displayed under the outfit details page

---

## ▶️ How to Run the Project

### Backend
1. Clone the repository
2. Open the backend project in IntelliJ
3. Configure MySQL details in `application.properties`
4. Run the Spring Boot application

### Frontend
1. Open frontend files using **Live Server** in VS Code  
   (required for proper API communication)
2. Access the application through the browser
3. Login and start uploading outfits

---

## 🌐 Mobile Access

- Mobile and laptop must be connected to the same Wi-Fi network
- Access frontend using the laptop’s IP address
- Backend APIs are accessed dynamically based on the host

---

## 🎯 Learning Outcomes

- Understanding REST API design
- Handling file uploads in Spring Boot
- Managing one-to-many relationships in databases
- Frontend–backend integration using Fetch API
- Debugging real-world issues like CORS and network access
- Designing a scalable project structure

---

## 👤 Author

**Anudeep**  
Computer Science Graduate  
Full-Stack Java Developer (Fresher)


