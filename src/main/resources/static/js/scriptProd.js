$(document).ready(function () {
    
  listar();
  llenare();
});

function llenare(){
    $.ajax({
        url: "/prov/all",
        type: 'GET',
        success: function (x) {

            for (var i = 0; i < x.length; i++) {
                $("#proveedor").append(
                        "<option value='" + x[i].idproveedor + "'> " + x[i].proveedor + "</option>");
                $("#editar_pro").append(
                        "<option value='" + x[i].idproveedor + "'> " + x[i].proveedor+ "</option>");
            }
        }
    });
    
}
function listar() {
 
    $.ajax({
        url: "/pr/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].descripcion
                        + "</td><td>" + x[i].preciocosto + "</td><td>" + x[i].precioventa+ "</td><td>" + x[i].cantidad+ "</td><td>" + x[i].proveedor+ "</td><td><a href='#' onclick='editar("
                        + x[i].idproducto + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idproducto + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    });
}
function editar(id) {
    $.ajax({
        url: "/pr/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_descripcion").val(w.descripcion);
            $("#editar_costo").val(w.preciocosto);
            $("#editar_venta").val(w.precioventa);
            $("#editar_cantidad").val(w.cantidad);
            $("#editar_pro").val(w.idproveedor);
            $("#idpost").val(w.idproducto);
        }
    });
    $("#modalEditar").modal('show');
}
function eliminar(id) {

    bootbox.confirm({
        message: "Realmente desea Eliminar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/pr/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro eliminado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
            } else {
                bootbox.alert({
                    message: "Registro no eliminado!",
                    size: 'small'
                });
            }
        }
    });
}

$("#guardar").click(function () {
    var descripcion = $("#descripcion").val();
    var costo = $("#costo").val();
    var venta = $("#venta").val();
    var cantidad = $("#cantidad ").val();
    var idproveedor = $("#proveedor").val();
    $.ajax({
        url: "/pr/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'descripcion': descripcion, 'preciocosto':  costo, 'precioventa': venta ,'cantidad': cantidad ,'idproveedor': idproveedor }),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            listar();
            limpiar();
        }
    });
    $("#modalGuardar").modal('hide');
});

function limpiar() {
    $("#descripcion").val("");
    $("#costo").val("");
    $("#venta").val("");
    $("#cantidad").val("");
    $("#proveedor").val("");
}

$("#modificar").click(function () {
    var descripcion = $("#editar_descripcion").val();
    var costo = $("#editar_costo").val();
    var venta = $("#editar_venta").val();
    var cantidad = $("#editar_cantidad").val();
    var idproveedor = $("#editar_pro").val();
    var idproducto = $("#idpost").val();
    
    bootbox.confirm({
        message: "Realmente desea Modificar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/pr/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'descripcion': descripcion, 'preciocosto': costo, 'precioventa': venta, 'cantidad': cantidad, 'idproveedor': idproveedor,'idproducto': idproducto}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
                $("#modalEditar").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});