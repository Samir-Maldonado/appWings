$(document).ready(function () {
  listar();
});

// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('button', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();

function listar() {
    $.ajax({
        url: "/clie/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].nombre
                        + "</td><td>" + x[i].dni + "</td><td>" + x[i].telefono + "</td><td><a href='#' onclick='editar("
                        + x[i].idcliente + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idcliente + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    });
}

function editar(id) {
    $.ajax({
        url: "/clie/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_titulo").val(w.nombre);
            $("#editar_descripcion").val(w.dni);
            $("#editar_telefono").val(w.telefono);
            $("#idpost").val(w.idcliente);
        }
    });
    $("#modalEditar").modal('show');
}

$("#guardar").click(function () {
    var nombre = $("#nombre").val();
    var dni = $("#dni").val();
    var telefono = $("#telefono").val();
    $.ajax({
        url: "/clie/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'nombre': nombre, 'dni': dni, 'telefono': telefono}),
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
                    url: "/clie/" + id,
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
                    url: "/clie/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idcliente': id, 'nombre': titulo, 'dni': desc, 'telefono': tel}),
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
