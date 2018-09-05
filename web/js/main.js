

//document.getElementById("ajaxBasico").addEventListener("click", function(){
//    var xhttp = new XMLHttpRequest();
//    xhttp.onreadystatechange = function(){
//        if(this.readyState == 4 && this.status == 200) {
//            document.getElementById("solicitud_1").innerHTML += JSON.stringify(this.responseText);
//        }
//    };
//    xhttp.open("GET", "https://swapi.co/api/people/?format=json&page=1", true);
//    xhttp.send();
//});
var pPan = [], pSalchicha = [];
$("#add-Dogo").click(function () {
    $("#precio-neto")[0].value = 0;
    $.each($("#Select-Salchichas")[0], function (i, field) {
        $("#Select-Salchichas")[0][1] != null ? $("#Select-Salchichas")[0][1].remove() : null;
    });
    $.get("Salchichas", function (data, status) {
        //console.log(data.Salchichas);
        pSalchicha[0] = 0;
        $.each(data.Salchichas, function (i, field) {
            $("#Select-Salchichas").html($("#Select-Salchichas").html() + "<option value=\"" + field.idSalchicha + "\">" + field.nombre + " $" + field.precio + "</option>");
            pSalchicha[i + 1] = field.precio;
        });
    });
    $.each($("#Select-Salchichas")[0], function (i, field) {
        $("#Select-Panes")[0][1] != null ? $("#Select-Panes")[0][1].remove() : null;
    });
    $.get("Panes", function (data, status) {
        //console.log(data);
        pPan[0] = 0;
        $.each(data.Panes, function (i, field) {
            $("#Select-Panes").html($("#Select-Panes").html() + "<option value=\"" + field.idPan + "\">" + field.nombre + " $" + field.precio + "</option>");
            pPan[i + 1] = field.precio;

        });
    });
    $("#precio-mas")[0].value = 0;
    $("#total-dogo")[0].value = 0;
    $("#loading").addClass("hidden");
    $("#Warning").addClass("hidden");
});

$("#Select-Salchichas").on("change", function () {
    generarNeto();
    generarTotal();
});

$("#Select-Panes").on("change", function () {
    generarNeto();
    generarTotal();
});

$("#precio-mas").on("change", function () {
    generarTotal();
});

function generarTotal() {
    var net = parseFloat($("#precio-neto")[0].value);
    var add = parseFloat($("#precio-mas")[0].value);
    var total = net + add;
    $("#total-dogo")[0].value = total;
    $("#Warning").addClass("hidden");
}

function generarNeto() {
    var valueSalchicha = pSalchicha[$("#Select-Salchichas option:selected")[0].value];
    var valuePan = pPan[$("#Select-Panes option:selected")[0].value];
    var total = parseFloat(valueSalchicha) + parseFloat(valuePan);
    $("#precio-neto")[0].value = total;
    $("#Warning").addClass("hidden");
}

$("#save-changes-dogo").click(function () {
    var idSalchicha = parseInt($("#Select-Salchichas option:selected")[0].value);
    var idPan = parseInt($("#Select-Panes option:selected")[0].value);
    if (validarDogo(idSalchicha, idPan)) {
        $("#loading").removeClass("hidden");
        var precio = parseFloat($("#total-dogo")[0].value);
        var data = {
            'idSachicha': idSalchicha,
            'idPan': idPan,
            'precio': precio
        };
        $.ajax({
            url: 'Dogost',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            success: function (msg) {
                console.log(msg);
                $("#loading").addClass("hidden");
            }
        });
    }
});

function validarDogo(a, b) {
    if (a == 0) {
        $("#Warning").removeClass("hidden");
        $("#Warning").text("Se debe de seleccionar una Salchicha");
        return false;
    }
    if (b == 0) {
        $("#Warning").removeClass("hidden");
        $("#Warning").text("Se debe de seleccionar un Pan");
        return false;
    }
    return true;
}








