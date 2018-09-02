

document.getElementById("ajaxBasico").addEventListener("click", function(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("solicitud_1").innerHTML += JSON.stringify(this.responseText);
        }
    };
    xhttp.open("GET", "https://swapi.co/api/people/?format=json&page=1", true);
    xhttp.send();
});



