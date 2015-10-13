FACTOR_CONVERSION = 1.609344;

function Conversor(){
	this.millas = NaN;
	this.kilometros = NaN;
	this.convertirAKilometros = function(){
		this.kilometros = this.millas * FACTOR_CONVERSION;
	};
	this.convertirAMillas = function() {
		this.millas = this.kilometros / FACTOR_CONVERSION;
	};
}