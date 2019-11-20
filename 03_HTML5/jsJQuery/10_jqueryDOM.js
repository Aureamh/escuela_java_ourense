//jQuery(...) se abrevia como $(...)
jQuery(document).ready(function () {

    jQuery("section").append("<div><p>LEYENDA de lo que sea</p></div>");

    //A todos los tr vamos a añadirles una columna:
    $("tr").append("<td>Info</td>");

    //Añadir quinta columna:
    $(".articulo").append("<p>UN PÁRRAFO EN CADA ELEMENTO con class = 'articulo'</p>");
    //Moficamos un atributo de esa columna:
    $("td:nth-child(5)").attr("style", "background-color: yellow; color: green");
    $("td:nth-child(5)").click(() => {
        alert('un click desde jQ');
    });

    $("#otro_menu").html('<h2>Menú de artículos</h2><br></br>');

    $("article").hide();
    $("article").each(function (index) {
        let idArticulo = "articulo_29juR_" + index
        $(this).attr("id", idArticulo);
        //$("#otro_menu").append("<a href='#" + idArticulo + "' id='enlace" + index + "' class='enlace-articulo'>Articulo nº"
        //+ index + "</a>");
        $("#enlace" + index).click(function () {
            $("#" + idArticulo).show();
        });
        
        // Para que al pulsar un artículo se oculte otro ya abierto.
        $("#otro_menu").append("<a id='enlace" + idArticulo + "' " + "' class='enlace-articulo'>Articulo nº"
        + index + "</a>");
        $("#enlace" + idArticulo).click(function(){
            if (typeof(articuloActivo) ==="undefined"){
                $("#" + idArticulo).slideDown(1500);
            }else {
                $(articuloActivo).slideUp(800,function() {
                    $("#" + idArticulo).slideDown(1500);
                });
            }
            articuloActivo = $("#" + idArticulo);
        })
        
        /* Para que queden fijos los artículos al pulsar
        $("#enlace" + idArticulo).click(function(){
            $("article").slideUp(800);
            $("#" + idArticulo).slideDown(1500);
        })*/

    });
    var articuloActivo; //Mientras esté fuera de la función no influye la posición,
                        //puede ser arriba o abajo.

    $("article").each(function (index) {
        console.log(index)
        $(this).append("<button id='cambia" + index + "'>Ocultar</button>");
        $("#cambia" + index).click(function () {
            $("#articulo_29juR_" + index).hide();
        });
    });
});