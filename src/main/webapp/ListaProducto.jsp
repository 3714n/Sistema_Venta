<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="CuerpoJSP/Head.jsp" %>
<%@include file="CuerpoJSP/Boddy1.jsp" %>
<div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Listado de Productos</h1>
                    <p class="mb-4">Bienvenido/a a la sección de administración de productos. 
                        Aquí encontrarás la lista completa de nuestros productos. 
                        Siéntete libre de seleccionar cualquier artículo 
                        para realizar cambios o eliminarlo según sea necesario.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Productos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Nombre</th>
                                            <th>V.Unitario</th>
                                            <th>C.Unidad</th>
                                            <th>Cantegoría</th>
                                            <th>Cantidad</th>
                                            <th>Descripción</th>
                                            <th>Imagen</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                         <tr>
                                            <th>Nombre</th>
                                            <th>V.Unitario</th>
                                            <th>C.Unidad</th>
                                            <th>Cantegoría</th>
                                            <th>Cantidad</th>
                                            <th>Descripción</th>
                                            <th>Imagen</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <tr>
                                            <td><a href="productos.html">Tiger Nixon</a></td>
                                            <td>System Architect</td>
                                            <td>Edinburgh</td>
                                            <td>61</td>
                                            <td>2011/04/25</td>
                                            <td>$320,800</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

</div>
<%@include file="CuerpoJSP/Boddy2.jsp" %>