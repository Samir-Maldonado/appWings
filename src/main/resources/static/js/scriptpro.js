$(document).ready(function () {
  listar();
});

function listar() {
    $.ajax({
        url: "/prov/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].proveedor
                        + "</td><td>" + x[i].telefono + "</td><td>" + x[i].direccion + "</td><td><a href='#' onclick='editar("
                        + x[i].idproveedor + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idproveedor+ ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    });
}
function editar(id) {
    $.ajax({
        url: "/prov/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_titulo").val(w.proveedor);
            $("#editar_descripcion").val(w.telefono);
            $("#editar_telefono").val(w.direccion);
            $("#idpost").val(w.idproveedor);
        }
    });
    $("#modalEditar").modal('show');
}

$("#guardar").click(function () {
    var nombre = $("#proveedor").val();
    var dni = $("#telefono").val();
    var telefono = $("#direccion").val();
    $.ajax({
        url: "/prov/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'proveedor': nombre, 'telefono': dni, 'direccion': telefono}),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            listar();
        }
    });
    $("#modalGuardar").modal('hide');
});

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
                    url: "/prov/" + id,
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

$("#modificar").click(function () {
    var titulo = $("#editar_titulo").val();
    var desc = $("#editar_descripcion").val();
    var tel = $("#editar_telefono").val();
    var id = $("#idpost").val();
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
                    url: "/prov/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idproveedor': id, 'proveedor': titulo, 'telefono': desc, 'direccion': tel}),
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
