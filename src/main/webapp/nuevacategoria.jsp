<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="Componest/head.jsp" %>
<%@include file ="Componest/boddy1.jsp" %>
<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Nueva categoria</h1>
  </div>
  

   <div class="container">
    <div class="row">
        <div class="col-md-10">
            <div class="p-5">
                <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Agregar Nueva Categoría</h1>
                </div>
                <form class="user">
                    <div class="form-group">
                        <label for="nuevaCategoria">Descripción:</label>
                        <div class="col-md-12 mb-3 mb-md-0">
                            <input type="text" class="form-control form-control-user" id="nuevaCategoria"
                                placeholder="Ingrese la descripción">
                        </div>
                    </div>
                    <a href="#" class="btn btn-primary btn-user btn-block">Guardar</a>
                    <hr>
                </form>
            </div>
        </div>
    </div>
</div>
  
<%@include file ="Componest/boddy2.jsp" %>