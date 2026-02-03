async function loadImages() {

    const response = await fetch("http://localhost:8080/images/all");
    const images = await response.json();

    const galleryDiv = document.getElementById("gallery");

    galleryDiv.innerHTML = "";

    for (let img of images) {

        const imageTag = document.createElement("img");

        imageTag.src =
            `data:${img.fileType};base64,${img.imageData}`;

        imageTag.onclick = function () {
            alert("Image ID: " + img.id);
        };

        galleryDiv.appendChild(imageTag);
    }
}

// Load images when page opens
loadImages();
