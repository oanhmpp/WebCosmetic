<div class="main-sidebar sidebar-style-2">
    <aside id="sidebar-wrapper">
        <div class="sidebar-brand">
            <a href="index.jsp"> <img alt="image" src="assets/img/logo.png" class="header-logo" /> <span
                    class="logo-name">Otika</span>
            </a>
        </div>
        <ul class="sidebar-menu">
            <li class="menu-header">Main</li>
            <li class="dropdown active">
                <a href="index.jsp" class="nav-link"><i data-feather="monitor"></i><span>Dashboard</span></a>
            </li>
            <li class="dropdown">
                <a href="#" class="menu-toggle nav-link has-dropdown"><i
                        data-feather="briefcase"></i><span>Widgets</span></a>
                <ul class="dropdown-menu">
                    <li><a class="nav-link" href="<c:url value ="/admin/product/list"/>">List Product</a></li>
                    <li><a class="nav-link" href="<c:url value ="/admin/brand/list"/>">List Brand</a></li>
                    <li><a class="nav-link" href="<c:url value ="/admin/type/list"/>">List Type</a></li>
<%--                    <li><a class="nav-link" href="<c:url value ="/admin/user/list"/>">List User</a></li>--%>
<%--                    <li><a class="nav-link" href="<c:url value ="/admin/order/list"/>">List Order</a></li>--%>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="menu-toggle nav-link has-dropdown"><i data-feather="command"></i><span>Apps</span></a>
                <ul class="dropdown-menu">
                    <li><a class="nav-link" href="chat.html">Chat</a></li>
                    <li><a class="nav-link" href="portfolio.html">Portfolio</a></li>
                    <li><a class="nav-link" href="blog.html">Blog</a></li>
                    <li><a class="nav-link" href="calendar.html">Calendar</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="menu-toggle nav-link has-dropdown"><i data-feather="mail"></i><span>Email</span></a>
                <ul class="dropdown-menu">
                    <li><a class="nav-link" href="email-inbox.html">Inbox</a></li>
                    <li><a class="nav-link" href="email-compose.html">Compose</a></li>
                    <li><a class="nav-link" href="email-read.html">read</a></li>
                </ul>
            </li>
        </ul>
    </aside>
</div>