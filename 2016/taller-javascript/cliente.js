"use strict";

function CriterioMontoCredito() { }
CriterioMontoCredito.prototype.montoMaximo = function(unCliente) {
    return 0.3 * unCliente.ingreso;
}

function CriterioComun() {}
CriterioComun.extends(CriterioMontoCredito);

function CriterioEspecial() {}
CriterioEspecial.extends(CriterioMontoCredito);
CriterioEspecial.prototype.montoMaximo = function(unCliente) {
  return this.parent.montoMaximo(unCliente) + 2000;
}

function CriterioDudoso() {
  this.prototype = new CriterioMontoCredito();

  this.montoMaximo = function(unCliente) {
    if (unCliente.deuda > 5000){
      return 100
    }
    else {
      return this.prototype.montoMaximo(unCliente);
    }
  }
}


function Cliente() {
  this.deuda   = 0;
  this.ingreso = 10000;
  this.criterioMontoCredito = new CriterioComun();

  this.comprar = function(monto) {
    this.deuda = this.deuda + monto;
  }

  this.pagarVencimiento = function(monto) {
    this.deuda = this.deuda - monto;
  }

  this.montoMaximoCredito = function() {
    return this.criterioMontoCredito.montoMaximo(this);
  }

  this.saldo = function() {
    return this.ingreso - this.deuda;
  }
}


describe("un cliente", function() {
  var manuel;
  var ricardo;

  beforeEach(function() {
    manuel = new Cliente();
    manuel.comprar(100);

    ricardo = new Cliente();
    ricardo.criterioMontoCredito = new CriterioEspecial();
    ricardo.deuda = 1000;
  });

  it('cuando compra deberia aumentar la deuda', function() {
    expect(manuel.deuda).toBe(100);
  });

  it('por defecto tiene el 30% de sus ingresos monto máximo de crédito', function() {
    expect(manuel.montoMaximoCredito()).toBe(3000);
  });

  it("cambio el monto máximo de crédito para adaptarlo a la mitad de los ingresos - deuda", function() {
    expect(ricardo.montoMaximoCredito()).toBe(4500);
  });

});
