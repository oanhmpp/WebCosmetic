<div class="navbar-bg"></div>
<nav class="navbar navbar-expand-lg main-navbar sticky">
    <div class="form-inline mr-auto">
        <ul class="navbar-nav mr-3">
            <li><a href="#" data-toggle="sidebar" class="nav-link nav-link-lg
									collapse-btn"> <i data-feather="align-justify"></i></a></li>
            <li><a href="#" class="nav-link nav-link-lg fullscreen-btn">
                <i data-feather="maximize"></i>
            </a></li>
<%--            <li>--%>
<%--                <form class="form-inline mr-auto">--%>
<%--                    <div class="search-element">--%>
<%--                        <input class="form-control" type="search" placeholder="Search" aria-label="Search"--%>
<%--                               data-width="200">--%>
<%--                        <button class="btn" type="submit">--%>
<%--                            <i class="fas fa-search"></i>--%>
<%--                        </button>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </li>--%>
        </ul>
    </div>
    <ul class="navbar-nav navbar-right">
        <li class="dropdown dropdown-list-toggle">
            <a href="#" data-toggle="dropdown"
               class="nav-link notification-toggle nav-link-lg">
                <i STYLE="color: #0D0A0A;font-size: 30px" class="far fa-user"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right pullDown">
                <div class="dropdown-title">Hello Admin</div>
                <a href="/myAccount" class="dropdown-item has-icon"> <i class="far
										fa-user"></i> Profile
                </a>
                <div class="dropdown-divider"></div>
                <a href="/logout" class="dropdown-item has-icon text-danger"> <i class="fas fa-sign-out-alt"></i>
                    Logout
                </a>
            </div>
        </li>
<%--        <li class="dropdown">--%>
<%--            <div class="dropdown-menu dropdown-menu-right pullDown">--%>
<%--                <div class="dropdown-title">Hello Admin</div>--%>
<%--                <a href="/myAccount" class="dropdown-item has-icon"> <i class="far--%>
<%--										fa-user"></i> Profile--%>
<%--                </a>--%>
<%--                <div class="dropdown-divider"></div>--%>
<%--                <a href="/logout" class="dropdown-item has-icon text-danger"> <i class="fas fa-sign-out-alt"></i>--%>
<%--                    Logout--%>
<%--                </a>--%>
<%--            </div>--%>
<%--        </li>--%>
    </ul>
</nav>