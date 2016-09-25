function Cliente() {
  this.deuda   = 0;
  this.ingreso = 10000;

  this.comprar = function(monto) {
    this.deuda = this.deuda + monto;
  }

  this.pagarVencimiento = function(monto) {
    this.deuda = this.deuda - monto;
  }

  this.montoMaximoCredito = function() {
    return 0.3 * this.ingreso;
  }
}


describe("un cliente", function() {
  var manuel;

  beforeEach(function() {
    manuel = new Cliente();
    manuel.comprar(100);
  });

  it('cuando compra deberia aumentar la deuda', function() {
    expect(manuel.deuda).toBe(100);
  });

  it('tiene el 30% de sus ingresos monto maximo de credito', function() {
    expect(manuel.montoMaximoCredito()).toBe(3000);
  });

  it("cambio el monto maximo de credito para adaptarlo a la mitad de los ingresos - deuda", function() {
    manuel.deuda = 1000;
    manuel.montoMaximoCredito = function() {
      return 0.5 * (this.ingreso - this.deuda);
    };
    expect(manuel.montoMaximoCredito()).toBe(4500);
  });

});
