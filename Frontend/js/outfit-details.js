let outfitId;

async function loadOutfit() {

    const params = new URLSearchParams(window.location.search);
    outfitId = params.get("id");

    // 1️⃣ Load outfit details
    const response = await fetch(
        `${BASE_URL}/api/outfit/${outfitId}`
    );
    const data = await response.json();

    // Show first image
    const mainImage = document.getElementById("mainImage");
    mainImage.src =
        `data:${data.images[0].fileType};base64,${data.images[0].imageData}`;

    // Product link
    document.getElementById("outfitLink").href = data.outfitLink;

    // Thumbnails
    const thumbnails = document.getElementById("thumbnails");
    thumbnails.innerHTML = "";

    data.images.forEach(img => {
        const thumb = document.createElement("img");
        thumb.src =
            `data:${img.fileType};base64,${img.imageData}`;
        thumb.width = 80;
        thumb.style.margin = "5px";
        thumb.style.cursor = "pointer";

        thumb.onclick = () => {
            mainImage.src = thumb.src;
        };

        thumbnails.appendChild(thumb);
    });

    loadReviews();
}

async function loadReviews() {
    const response = await fetch(
        `${BASE_URL}/api/reviews/${outfitId}`
    );
    const reviews = await response.json();

    const reviewDiv = document.getElementById("reviews");
    reviewDiv.innerHTML = "";

    reviews.forEach(r => {
        const p = document.createElement("p");
        p.innerText = `${r.userName}: ${r.comment}`;
        reviewDiv.appendChild(p);
    });
}

async function addReview() {

    const comment = document.getElementById("comment").value;
    const email = localStorage.getItem("email");
        console.log(comment);
         console.log(comment);
          console.log(comment);
    await fetch(`${BASE_URL}/api/add`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            comment: comment,
            outfitId: outfitId,
            email: email
        })
    });

    document.getElementById("comment").value = "";
    loadReviews();
}

document.addEventListener("DOMContentLoaded", loadOutfit);
