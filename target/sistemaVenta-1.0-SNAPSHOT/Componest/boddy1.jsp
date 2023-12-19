

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Logo -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-regular fa-bag-shopping"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Fogata Ecotravel </div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Menu -->
                <li class="nav-item active">
                    <a class="nav-link" href="index.html">
                        <i class="fas fa-solid fa-bars"></i>
                        <span>Menu</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- interface -->
                <div class="sidebar-heading">
                    Interface
                </div>

                <!-- aqui - despliegue del menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                       aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-regular fa-cart-shopping"></i>
                        <span>Venta</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Custom Components:</h6>
                            <a class="collapse-item" href="nuevaventa.jsp">Nueva venta</a>
                            <a class="collapse-item" href="listaventa.jsp">Lista de ventas</a>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                       aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-brands fa-product-hunt"></i>
                        <span>Producto</span>
                    </a>
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                         data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Producto</h6>
                            <a class="collapse-item" href="nuevoproducto.jsp">Nuevo producto</a>
                            <a class="collapse-item" href="gestionarproducto.jsp">Gestionar producto</a>
                            <a class="collapse-item" href="actualizarstock.jsp">Actualizar Stock</a>
                            <a class="collapse-item" href="nuevacategoria.jsp">Nueva categoria</a>
                            <a class="collapse-item" href="gestionarcategoria.jsp">Gestionar categoria</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Configuración
                </div>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePagesUsuario"
                       aria-expanded="true" aria-controls="collapsePagesUsuario">
                        <i class="fas fa-solid fa-user"></i>
                        <span>Usuario</span>
                    </a>
                    <div id="collapsePagesUsuario" class="collapse" aria-labelledby="headingPagesUsuario" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Opciones de Usuario:</h6>
                            <a class="collapse-item" href="nuevoUsuario.jsp">Nuevo usuario</a>
                            <a class="collapse-item" href="gestionarUsuario.jsp">Gestionar usuario</a>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePagesCliente"
                       aria-expanded="true" aria-controls="collapsePagesCliente">
                        <i class="fas fa-solid fa-person"></i>
                        <span>Cliente</span></a>
                    <div id="collapsePagesCliente" class="collapse" aria-labelledby="headingPagesCliente" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Opciones de Cliente:</h6>
                            <a class="collapse-item" href="nuevoCliente.jsp">Nuevo cliente</a>
                            <a class="collapse-item" href="gestionarCliente.jsp">Gestionar cliente</a>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Tables -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePagesReporte"
                       aria-expanded="true" aria-controls="collapsePagesReporte">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Reporte</span></a>
                 
                
                    <div id="collapsePagesReporte" class="collapse" aria-labelledby="headingPagesReporte" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Opciones de Reporte:</h6>
                            <a class="collapse-item" href="reporteCliente.jsp">Reporte cliente</a>
                            <a class="collapse-item" href="reporteCategoria.jsp">Reporte categoria</a>
                            <a class="collapse-item" href="reporteProducto.jsp">Reporte producto</a>
                            <a class="collapse-item" href="reporteVenta.jsp">Reporte venta</a>
                            <a class="collapse-item" href="reporteGastos.jsp">Reporte gastos</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>
            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>


                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                                    <img class="img-profile rounded-circle"
                                         src="img/undraw_profile.svg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Perfil
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Configuración
                                    </a>

                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Cerrar seción
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </nav>

                   