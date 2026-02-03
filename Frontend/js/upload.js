async function uploadImage() {

    const fileInput = document.getElementById("image");
    const files = fileInput.files;   // 👈 files (plural)
    const outfitLink = document.getElementById("outfitLink").value;

    if (files.length === 0) {
        alert("Please select at least one image");
        return;
    }

    const email = localStorage.getItem("email");
    if (!email) {
        alert("User not logged in");
        return;
    }

    const formData = new FormData();

    // 🔥 IMPORTANT: append as "files"
    for (let i = 0; i < files.length; i++) {
        formData.append("files", files[i]);
    }

    formData.append("email", email);
    formData.append("outfitLink", outfitLink);

    try {
        const response = await fetch(
            `${BASE_URL}/api/upload`,
            {
                method: "POST",
                body: formData
            }
        );

        const result = await response.text();
        alert(result);

        window.location.href = "../html/gallery.html";

    } catch (error) {
        console.error(error);
        alert("Upload failed");
    }
}

// async function uploadImage() {
    
//     const fileInput = document.getElementById("image");
//     const file = fileInput.files[0];
//     const outfitLink = document.getElementById("outfitLink").value;

//     //console.log(url);
//     if (!file) {
//         alert("Please select an image");
//         return;
//     }
//     const email = localStorage.getItem("email");
//             console.log(email)
//     if (!email) {
//         alert("User not logged in");
//         return;
//     }
//     const formData = new FormData();
//     formData.append("file", file);
//     formData.append("email", email);
//     formData.append("outfitLink", outfitLink);

//     try{
//         const response = await fetch("http://192.168.1.6:8080/api/upload", {
//             method: "POST",
//             body: formData
//         });
//         const result = await response.text();
//         alert(result);
//         fileInput.value = "";
//          alert("Image uploaded successfully");

//     // 🔥 STEP 3: GO BACK TO GALLERY
//     window.location.href = "../html/gallery.html";

//     } catch (error) {
//         console.error("Error:", error);
//         alert("Upload failed");
//     }
// }
// //document.addEventListener("DOMContentLoaded", uploadImage);