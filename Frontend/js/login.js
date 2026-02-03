
// document.getElementById("sub").addEventListener("submit", (e) => {
//     e.preventDefault();
//     const Details={
//         email:document.getElementById("email").value,
//         password:document.getElementById("password").value
//     };
//     fetch()
// }
// )
//import { loadImages } from "../ImagesDisplay/imagesdisplay.js";
document.getElementById("btm").addEventListener("click", async (e) => {
    e.preventDefault();   // stop page reload

    const details = {
        email: String(document.getElementById("email").value),
        password: String(document.getElementById("password").value)
    };
    console.log(details.email);
    try {
//         fetch("http://localhost:8080/api/Login", {
//   method: "POST",
//   headers: { "Content-Type": "application/json" },
//   body: JSON.stringify({
//     email: "test@gmail.com",
//     password: "1234"
//   })
// }).then(r => r.text()).then(console.log)

        const response = await fetch(`${BASE_URL}/api/Login`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(details)
        });
        const result = await response.text();
        if (result == "Invalid password"||result=="Email not found") {
            const p = document.createElement("p");
            p.textContent = result;
            document.getElementById("Container").append(p);
        }
        else{
            console.log(result+" happy")
                localStorage.setItem("email", result);
                alert("Login successful");
            window.location.href = "../html/gallery.html";
        }

        


    } catch (error) {
        console.error("Error:", error);
    }
});
