// Manera ECMAScript 5
function GestorEventosES5(inputId, btnId, divInfoId) {
    this.input = document.getElementById(inputId);
    this.boton = document.getElementById(btnId);
    this.divInfo = document.getElementById(divInfoId);
    this.funCallbackAlPulsarBIND = this.funCallbackAlPulsar.bind(this);
    this.boton.addEventListener("click", this.funCallbackAlPulsarBIND);

    this.funCallbackOnClick_2 = (evento) => {
        this.input.style = "background-color: lightblue;";
        evento.currentTarget.value = "Puedes repetir"; 

        this.divInfo.innerHTML += "evento.currentTarget.id = " + evento.currentTarget.id;
        this.divInfo.className = "div-marco";
        evento.currentTarget.removeEventListener("click", this.funCallbackAlPulsarBIND);
    };

    //En las funciones flecha, el this, es el this que tiene que ser, el objeto en 
    //el que estás. Por eso es muy recomendable usarlas, por eso quitamos el bind.
    this.boton.addEventListener("click", this.funCallbackOnClick_2);
}

GestorEventosES5.prototype.funCallbackAlPulsar = new Function("evento", `{
    this.input.value = "Tipo de evento: " + evento.type;
}`);
GestorEventosES5.metodoEstatico = function () {
    alert("Método estático");
}

class GestorEventosES6 { //Manera ECMAScript 2015 ó ES6
    constructor(inputId, btnId, divInfoId) {
        this.input = document.getElementById(inputId);
        this.boton = document.getElementById(btnId);
        this.divInfo = document.getElementById(divInfoId);
        this.boton.addEventListener("click", this.funCallbackAlPulsar.bind(this));
        this.boton.addEventListener("click", this.funCallbackOnClick_2);
    }

    funCallbackAlPulsar(evento) {
        this.input.value = "Type evento: " + evento.type;
    }

    funCallbackOnClick_2 = (evento) => {
        this.input.style = "background-color: lightblue;";
    }
}


