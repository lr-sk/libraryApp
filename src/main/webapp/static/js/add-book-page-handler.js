window.addEventListener("load", function () {
   setDateNow();
    let bookAuthors = document.getElementById("bookAuthors");

    bookAuthors.addEventListener("change", () => {showOptions(bookAuthors)});


});

function setDateNow() {
    let date = document.getElementById("bookRegistrationDate");
    let todayDate = new Date().toISOString().slice(0, 10);
    date.setAttribute("value", todayDate);
};


function showOptions(bookAuthors) {
    let selectedAuthorsBlock = document.getElementById("selectedAuthors");
    let bookAuthorsOptions = bookAuthors.getElementsByTagName("option");
    Array.from(bookAuthorsOptions).forEach(function (item) {
        let itemId = item.getAttribute("id");
        if (item.selected === true && selectedAuthorsBlock.querySelector("#"+itemId) == null) {
            let content = item.getAttribute("value");

            let badgeLink = document.createElement('a');
            badgeLink.setAttribute("href", "#");
            badgeLink.setAttribute("id", itemId);
            badgeLink.className = "badge badge-dark mr-1";
            badgeLink.textContent = content;
            selectedAuthorsBlock.appendChild(badgeLink);
        }
    });


};

