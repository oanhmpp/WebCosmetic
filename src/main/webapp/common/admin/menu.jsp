<div class="main-sidebar sidebar-style-2">
    <aside id="sidebar-wrapper">
        <div class="sidebar-brand">
            <a href="/"><img src="<c:url value="/resources/web/img/logo.png"/>" alt="Logo">
            </a>
        </div>
        <ul class="sidebar-menu">
            <li class="menu-header">Main</li>
            <li class="dropdown">
                <a href="#" class="menu-toggle nav-link has-dropdown"><i
                        data-feather="briefcase"></i><span>Manager</span></a>
                <ul class="dropdown-menu">
                    <li><a class="nav-link" href="<c:url value ="/admin/product/list"/>">List Product</a></li>
                    <li><a class="nav-link" href="<c:url value ="/admin/brand/list"/>">List Brand</a></li>
                    <li><a class="nav-link" href="<c:url value ="/admin/type/list"/>">List Type</a></li>
                    <li><a class="nav-link" href="<c:url value ="/admin/customer/list"/>">List Customer</a></li>
                    <li><a class="nav-link" href="<c:url value ="/admin/order/list"/>">List Order</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="menu-toggle nav-link has-dropdown"><i
                        data-feather="briefcase"></i><span>Revenue</span></a>
                <ul class="dropdown-menu">
                    <li>
                        <a class="nav-link" href="<c:url value ="/admin/revenue/brand"/>">Brand</a>
                    </li>
                    <li>
                        <a class="nav-link" href="<c:url value ="/admin/revenue/year"/>">Year</a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="menu-toggle nav-link has-dropdown"><i
                        data-feather="briefcase"></i><span>Sales</span></a>
                <ul class="dropdown-menu">
                    <li>
                        <a class="nav-link" href="<c:url value ="/admin/sales/brand"/>">Brand</a>
                    </li>
                    <li>
                        <a class="nav-link" href="<c:url value ="/admin/sales/year"/>">Year</a>
                    </li>
                </ul>
            </li>
        </ul>
    </aside>
</div>