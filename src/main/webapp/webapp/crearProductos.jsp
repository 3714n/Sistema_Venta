<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="CuerpoJSP/Head.jsp" %>
<%@include file="CuerpoJSP/Boddy1.jsp" %>
<div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="card o-hidden border-0 shadow-lg my-5">
            
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                                <div class="col-lg-7">
                                    
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4">Editar Producto</h1>
                                        </div>
                                        
                                      
                                         
                                        <form class="user" action="SvProducto" method="POST" >
                                            
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
                                            </div>
                                         
                                            
                                            <button class="btn btn-primary btn-user btn-block" type="submit">
                                                Guardar Producto
                                            </button>

                                        </form>
                                      </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
<%@include file="CuerpoJSP/Boddy2.jsp" %>