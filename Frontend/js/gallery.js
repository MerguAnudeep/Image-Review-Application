function goToUpload() {
    window.location.href = "../html/upload.html";
}

async function loadGallery() {

    const response = await fetch(`${BASE_URL}/api/gallery`);
    const outfits = await response.json();

    const gallery = document.getElementById("gallery");
    gallery.innerHTML = "";

    outfits.forEach(outfit => {

        const card = document.createElement("div");
        card.className = "image-card";

        const img = document.createElement("img");
        img.src = `data:${outfit.fileType};base64,${outfit.imageData}`;
        img.title = "Click to view outfit";
        img.onclick = () => {
            window.location.href =
                "../html/outfit-details.html?id=" + outfit.outfitId;
        };

        card.appendChild(img);

        // 🔗 Optional product link icon
        if (outfit.outfitLink) {
            const linkIcon = document.createElement("a");
            linkIcon.className = "link-icon";
            linkIcon.href = outfit.outfitLink;
            linkIcon.target = "_blank";
            linkIcon.innerHTML = "🔗";
            card.appendChild(linkIcon);
        }

        gallery.appendChild(card);
    });
}

document.addEventListener("DOMContentLoaded", loadGallery);

// function goToUpload() {
//     window.location.href = "../html/upload.html";
// }

// async function loadImages() {

//     const response = await fetch("http://192.168.1.6:8080/api/all");
//     const images = await response.json();

//     const gallery = document.getElementById("gallery");
//     gallery.innerHTML = "";

//     images.forEach(img => {

//         // 🔹 Wrapper div for image + icon
//         const card = document.createElement("div");
//         card.className = "image-card";

//         // 🔹 Image element
//         const imageTag = document.createElement("img");
//         imageTag.src = `data:${img.fileType};base64,${img.imageData}`;
//         // imageTag.style.width = "200px";
//         // imageTag.style.height = "200px";
//          imageTag.style.cursor = "pointer";
//         imageTag.title = "Click to view & review this outfit";

//         // Image click → review page
//         imageTag.onclick = () => {
//             window.location.href =
//                 "../html/image-details.html?id=" + img.id;
//         };

//         card.appendChild(imageTag);

//         // 🔗 Product link icon (ONLY if link exists)
//         if (img.outfitLink && img.outfitLink.trim() !== "") {
//             const linkIcon = document.createElement("a");
//             linkIcon.className = "link-icon";
//             linkIcon.href = img.outfitLink;
//             linkIcon.target = "_blank";
//             linkIcon.title = "View outfit link";

//             // Font Awesome icon
//             linkIcon.innerHTML = '<i class="fa-solid fa-link"></i>';

//             card.appendChild(linkIcon);
//         }

//         gallery.appendChild(card);
//     });
// }

// // Load images when page opens
// document.addEventListener("DOMContentLoaded", loadImages);

