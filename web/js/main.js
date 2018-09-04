

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

$("#add-Dogo").click(function () {
    $.each($("#Select-Salchichas")[0], function (i, field) {
    $("#Select-Salchichas")[0][1] != null ? $("#Select-Salchichas")[0][1].remove() : null;
    });
    $.get("Salchichas", function (data, status) {
        //console.log(data.Salchichas);
        $.each(data.Salchichas, function (i, field){
            $("#Select-Salchichas").html($("#Select-Salchichas").html() + "<option value=\"" + field.idSalchicha + "\">Salchicha " + field.nombre + " $ " + field.precio + "</option>"); 
        });
    });
});

$("#add-Dogo").click(function () {
    $.each($("#Select-Salchichas")[0], function (i, field) {
    $("#Select-Panes")[0][1] != null ? $("#Select-Panes")[0][1].remove() : null;
    });
    $.get("Panes", function (data, status) {
        //console.log(data);
        $.each(data.Panes, function (i, field){
            $("#Select-Panes").html($("#Select-Panes").html() + "<option value=\"" + field.idSalchicha + "\">Pan " + field.nombre + " $ " + field.precio + "</option>"); 
        });
    });
});



