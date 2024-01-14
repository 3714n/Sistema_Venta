<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="CuerpoJSP/Head.jsp" %>
<%@include file="CuerpoJSP/Boddy1.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-7">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Nueva categoria</h1>
                                </div>
                                <form class="user" action="SvCategoria" method="POST">
                                    <div class="form-group row">
                                        <div class="col-sm-12 mb-3">
                                            <input type="text" class="form-control form-control-user" id="nombreCategoria" name="nombreCategoria"
                                                   placeholder="Nombre de la categoría">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-user btn-block">
                                        Guardar Categoria
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="CuerpoJSP/Boddy2.jsp" %>