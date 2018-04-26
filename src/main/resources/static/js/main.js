{
    "use strict";

    let logoutAnchor = document.getElementById("logout");
    let logoutForm = document.getElementById("logout-form");

    if (logoutAnchor !== null) {
        logoutAnchor.addEventListener("click", (e) => {
            e.preventDefault();
            logoutForm.submit();
        });
    }

}