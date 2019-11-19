//jQuery(...) se abrevia como $(...)
jQuery(document).ready(function() {

    jQuery("section").append("<div><p>LEYENDA de lo que sea</p></div>");

    //A todos los tr vamos a añadirles una columna:
    $("tr").append("<td>Info</td>");

    //Añadir quinta columna:
    $(".articulo").append("<p>UN PÁRRAFO EN CADA ELEMENTO con class = 'articulo'</p>");
    //Moficamos un atributo de esa columna:
    $("td:nth-child(5)").attr("style","background-color: yellow; color: green");
    $("td:nth-child(5)").click(() => {
        alert('un click desde jQ');
    });

    $("#otro_menu").append('<p>.....</p><br></br>');
    $("#otro_menu").click(function() {
        //$('#otro_menu').fadeOut();
        $(this).slideUp();
    });

    $(".articulo").append("<button class='cambia'>Cambia visualización</button>");
    $(".cambia").click(function() {
        $("article").hide();

    });

    
});

