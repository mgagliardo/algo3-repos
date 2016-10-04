function Apuesta() {
    "use strict";
    this.fecha = new Date();
    this.monto = 0;
    this.tipoApuesta = null;
    this.valorApostado = null;
    this.resultado = null;

    this.apostar = function() {
      var numeroGanador = Math.floor(Math.random() * 37);
      var gano = this.tipoApuesta.esGanador(numeroGanador, this.valorApostado);
      var ganancia = 0;
      if (gano) {
        ganancia = this.monto * this.tipoApuesta.ganancia;
      }
      this.resultado = new Resultado(gano, numeroGanador, ganancia);
    };
}



function Pleno() {
    "use strict";
    this.descripcion = 'Pleno';
    this.valoresAApostar = list(1, 36);
}

/**
  * Un constructor de lista copado
  */
function list(start, end) {
    anArray = [];
    for (var i = start; i <= end; i += 1) {
          anArray.push(i);
    }
    return anArray;
}

function Docena() {
    "use strict";
    this.descripcion = 'Docena';
    this.valoresAApostar = ["Primera", "Segunda", "Tercera"];
}
