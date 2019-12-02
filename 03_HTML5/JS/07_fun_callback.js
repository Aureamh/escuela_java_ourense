//-----FUNCIONES CALLBACK(RETROLLAMADA)-----

//Nomenclatura típica de function en variable
let suma = function(x,y){
    return x+y;
}

//Nomenclatura típica de function
let multiplica = function(x,y){
    return x*y;
}

//Nomenclatura de objeto Function
let divide = new Function("x","y","return x/y;");

//Nomenclatura de función flecha
let resta=(x,y) => {
    return x-y;
}

let coordenadas =function(x,y){
    return `(${x},${y})`;
}
