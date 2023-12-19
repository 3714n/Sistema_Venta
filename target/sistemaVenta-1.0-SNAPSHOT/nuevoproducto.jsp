<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="Componest/head.jsp" %>
<%@include file ="Componest/boddy1.jsp" %>
<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Nuevo producto</h1>
    </div>

    <!-- Formulario -->
    <div class="container">
        <div class="row">
            <div class="col-md-10">
                <div class="p-5">
                    <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Agregar Nuevo Producto</h1>
                    </div>
                    <form class="user">
                        <div class="form-group row">
                            <label for="NombreProducto" class="col-md-2 col-form-label">Nombre:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control form-control-user" id="NombreProducto"
                                    placeholder="Ingrese el nombre">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="cantidadProducto" class="col-md-2 col-form-label">Cantidad:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control form-control-user" id="cantidadProducto"
                                    placeholder="Ingrese la cantidad">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="precioProducto" class="col-md-2 col-form-label">Precio:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control form-control-user" id="precioProducto"
                                    placeholder="Ingrese el precio">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="descripcionProducto" class="col-md-2 col-form-label">Descripción:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control form-control-user" id="descripcionProducto"
                                    placeholder="Ingrese la descripción">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="categoriaProducto" class="col-md-2 col-form-label">Categoría:</label>
                            <div class="col-md-6">
                                <select class="form-control" id="categoriaProducto">
                                    <!-- Aquí puedes agregar opciones para tu combobox -->
                                    <option value="opcion1">Opción 1</option>
                                    <option value="opcion2">Opción 2</option>
                                    <option value="opcion3">Opción 3</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-6 offset-md-2">
                                <a href="#" class="btn btn-primary btn-user btn-block">Guardar</a>
                            </div>
                        </div>

                        <hr>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file ="Componest/boddy2.jsp" %>