<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="CuerpoJSP/Head.jsp" %>
<%@include file="CuerpoJSP/Boddy1.jsp" %>
<div class="container-fluid">

                <div class="card o-hidden border-0 shadow-lg my-5">
            
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                            <div class="col-lg-7">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Nuevo Producto</h1>
                                    </div>
                                    <form class="user" action="SvProducto" method="POST" enctype="multipart/form-data">
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" id="nombreProducto" name="nombreProducto"
                                                    placeholder="Nombre">
                                            </div>
                                            <div class="col-sm-6">
                                                <input type="number" class="form-control form-control-user" id="cantidadProducto" name="cantidadProducto"
                                                    placeholder="Cantidad">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" id="precioProducto" name="precioProducto"
                                                    placeholder="Precio" pattern="^\d+(\.\d{1,2})?$">
                                            </div>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control form-control-user" id="descripcionProducto" name="descripcionProducto"
                                                    placeholder="Descripcion" >
                                            </div>
                                            <div class="mb-3 mt-3 ml-3">
                                                <label for="formFile" class="form-label">Cargar imagen</label>
                                                <input class="form-control" type="file" id="cargarImagenProducto" name="cargarImagenProducto">
                                              </div>
        
                                        </div>
                                       
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user"
                                                    id="costoProducto" name="costoProducto" placeholder="Costo">
                                            </div>
                                            <div class="col-sm-6">
                                                <select class="form-control form-control-user" id="categoriaProducto">
                                                    <option value="" disabled selected>Selecciona una categoría</option>
                                                    <option value="opcion1">Opción 1</option>
                                                    <option value="opcion2">Opción 2</option>
                                                    <option value="opcion3">Opción 3</option>
                                                    <!-- Puedes agregar más opciones según tus necesidades -->
                                                </select>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-user btn-block">
                                            Guardar producto
                                        </button>
                                        
                                    </form>
                                   
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
<%@include file="CuerpoJSP/Boddy2.jsp" %>