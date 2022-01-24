window.addEventListener("load", function() {
    handleDropdownItemBook();
    handleToggleMainNavbar();


});

function handleDropdownItemBook() {
    let navbarItemBook = document.getElementById("navbarItemBook");
    let navbarLinkBook = document.getElementById("navbarLinkBook");
    let dropdownMenuBook = document.getElementById("dropdownMenuBook");

    navbarLinkBook.addEventListener("click", () => {handleDropdownMenu(navbarItemBook, navbarLinkBook, dropdownMenuBook)});
}

function handleDropdownMenu(navbarItem, navbarLink, dropdownMenu) {
    if (navbarItem.classList.contains("show") && dropdownMenu.classList.contains("show")) {
        navbarItem.classList.remove("show");
        dropdownMenu.classList.remove("show");
        navbarLink.setAttribute("aria-expanded", "false");
    } else {
        navbarItem.classList.add("show");
        dropdownMenu.classList.add("show");
        navbarLink.setAttribute("aria-expanded", "true");
    }
}

function handleToggleMainNavbar() {
    let mainNavbar = document.getElementById("mainNavbar");
    let mainNavbarToggleButton = document.getElementById("mainNavbarToggleButton");

    mainNavbarToggleButton.addEventListener("click", () => {handleToggleMenu(mainNavbar, mainNavbarToggleButton)});

}

function handleToggleMenu(mainNavbar, mainNavbarToggleButton) {
    if (mainNavbar.classList.contains("show")) {
        mainNavbar.classList.remove("show");
        mainNavbarToggleButton.classList.add("collapsed");
    } else {
        mainNavbar.classList.add("show");
        mainNavbarToggleButton.classList.remove("collapsed");
    }
}