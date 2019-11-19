function operarArrays(arrX, arrY, operaCallback) {
    //Comprobamos que el tamaño de los arrays son el mismo
    if (arrX.length == arrY.length) {
        //Declaramos un array con la palabra var: ámbito es de función.
        //A diferencia de let de ES6, que sí es ámbito a nivel de bloque.
        var arrayResultado = new Array();
        for(let i=0; i<arrX.length;i++){
            arrayResultado[i] = operaCallback(arrX[i],arrY[i]);
        }
    }
    return arrayResultado;
}

    //Otra forma de declarar un array:

    var arrayEjemplo = [];
    //Notación JASON (puede ser vacío o lleno).
    //No indicamos el tamaño, porque en realidad los arrays de JS son como los 
    //ArrayList<Object> de Java. Es decir, son dinámicos. 
    //Incluso se parece más a un HashMap cuya clave es un Integer. 
    //HashMap<Integer,Object>
    arrayEjemplo.push("Primer elemento");
    arrayEjemplo[10] = "lo que sea";
    