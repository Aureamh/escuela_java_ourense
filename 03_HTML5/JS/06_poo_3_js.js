//Notación JSON: (JavaScript Object Notation)
//Lo que se puede almacenar en XML, se puede convertir a JSON y viceversa.
//Todo se puede almacenar como JSON

var unObjeto = {}; //Esto es lo mismo que hacer: new Object();
var otroObjeto = {
    "prop_1": "Propiedad uno",
    "prop_2": "Propiedad dos",
    'prop_3': 'Propiedad tres',
    prop_4: "Propiedad cuatro",
    toString: function () {
        return "Propiedades: " + this.prop_1 + ";" + this.prop_2 + ";"
            + this.prop_3 + ";" + this.prop_4 + ";" + this.prop_5
    },
    toStringAll: function () {
        var strProp = "Lista de propiedades: <br/>";
        for (var i = 0; i < 20; i++) {
            if (typeof (this["prop_" + i]) !== "undefined") {
                strProp += this["prop_ " + i] + ";";
            }
        }
        return strProp;
    },
    toStringTodasVariablesMiembroProp: function () {
        var strProp = "Lista de TODAS las propiedades: <br/>";
        for (key in this) {
            strProp += this[key] + ";";
        }
        return strProp;
    },

    toStringAllProp: function () {
        var strProp = "Lista de TODAS las propiedades: <br/>";
        for (key in this) {
            if (key.indexOf("prop_") >= 0)
                strProp += this[key] + ";";
        }
        return strProp;
    },

    toStringAllZaira: function () {
        var strProp = "Lista de propiedades modo Zaira: <br/>";
        var largo = Object.keys(this).length;
        var j = 1;
        for (var i = 0; i < largo; i++) {
            //if (Object.keys(this)[i].indexOf("prop_")>=0) {
            var largoNum = Object.keys(this)[i].length;
            var numProp = Object.keys(this)[i].substr(5, largoNum);
            if (Object.keys(this)[i] == "prop_" + numProp) {
                strProp += Object.values(this)[i] +"<br/>";
                //j++;
            }
        }
        return strProp;
    }

}


otroObjeto.prop_5 = "Propiedad cinco";
otroObjeto.prop_19 = "Propiedad diecinueve";
otroObjeto.prop_172 = "Propiedad ciento setenta y dos"
var divTris = document.getElementById("contenido_tris");
divTris.innerHTML += otroObjeto.toString();
divTris.innerHTML += "<br/>" + otroObjeto.toStringAll();
divTris.innerHTML += "<br/>" + otroObjeto.toStringTodasVariablesMiembroProp();
divTris.innerHTML += "<br/>" + otroObjeto.toStringAllProp();
divTris.innerHTML += "<br/>" + otroObjeto.toStringAllZaira();