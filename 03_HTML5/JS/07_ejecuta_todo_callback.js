
        let array_A = [1,2,3,4,5];
        let array_B = [2,3,4,5,6];

        let arraysumaAB = operarArrays(array_A,array_B,suma);
        arrayEnTabla(arraysumaAB);

        let arraymultiplicaAB = operarArrays(array_A,array_B,multiplica);
        arrayEnTabla(arraymultiplicaAB);

        let arraydivideAB = operarArrays(array_A,array_B,divide);
        arrayEnTabla(arraydivideAB);
        //Otra forma,funciones flecha:
        //let arraydivideAB = operarArrays(array_A,array_B,(x,y) => x/y);
        //arrayEnTabla(arraydivideAB);


        let arrayrestaAB = operarArrays(array_A,array_B,resta);
        arrayEnTabla(arrayrestaAB);

        let arraycoordenadasAB = operarArrays(array_A,array_B,coordenadas);
        arrayEnTabla(arraycoordenadasAB);

        function arrayEnTabla(array){
            let tabla = "<table border=2><tr>";
                for (let index = 0; index < array.length; index++) {
                    const element = array[index];
                    tabla += "<td>&nbsp;" + element + " &nbsp;</td>"
                }
        
        document.getElementById("contenido").innerHTML += tabla + "</tr></table>";
    }