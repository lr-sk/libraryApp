<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="main"><i class="fas fa-book-open"></i> Library</a>
        <button class="navbar-toggler collapsed" id="mainNavbarToggleButton" type="button" data-toggle="collapse"
                data-target="#mainNavbar" aria-controls="mainNavbar" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mainNavbar">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown" id="navbarItemBook">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarLinkBook" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Books
                    </a>
                    <div class="dropdown-menu" id="dropdownMenuBook" aria-labelledby="navbarLinkBook">
                        <a class="dropdown-item" href="all-books-table">Table view</a>
                        <a class="dropdown-item" href="all-books-gallery">Gallery view</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="all-bookings">Bookings</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="all-clients">Clients</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="library-yield">Library yield</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="writing-off-books">Writing off books</a>
                </li>
            </ul>
<%--            <form class="form-inline my-2 my-lg-0">--%>
<%--                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>--%>
<%--            </form>--%>
        </div>
    </div>
</nav>
<div class="container mt-5">