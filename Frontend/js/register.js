
// document.getElementById("btn").addEventListener("click", async(e) => {
//      e.preventDefault(); 
//     const box = document.querySelector(".box");
//     const Details={
//             Name:document.getElementById("userName").value,
//             Email:document.getElementById("email").value,
//             password:document.getElementById("password").value,
//             Age:document.getElementById("age").value,
//             Mobile_no:document.getElementById("mobileNo").value,
//             Location:document.getElementById("location").value
           
//     };
//       await fetch("http://localhost:8080/api/map", {
//         method: "POST",
//         headers: {
//             "Content-Type": "application/json"
//         },
//         body: JSON.stringify(details)
//     });
//      console.log(Details.Name);
//     box.style.backgroundColor = "yellow";
// });

document.getElementById("btn").addEventListener("click", (e) => {
    e.preventDefault();

    const details = {
        UserName: String(document.getElementById("userName").value),
        email: String(document.getElementById("email").value),
        password: String(document.getElementById("password").value),
        Age: Number(document.getElementById("age").value),
        
        mobile_no: String(document.getElementById("mobileNo").value),
        Location: String(document.getElementById("location").value)
    };
    console.log(details.Mobile_No)
    fetch(`${BASE_URL}/api/map`,{
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(details)
    })
    .then(() => {
        alert("Registered Successfully");
        window.location.href = "../html/login.html";
        // request completed
    })
    .catch(error => {
        console.error("Error:", error);
    });
});

