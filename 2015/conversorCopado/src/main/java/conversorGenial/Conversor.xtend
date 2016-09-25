package conversorGenial

import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors

@Observable
@Accessors
class Conversor {
	
	static double FACTOR_CONVERSION = 1.609344
	double millas
	double kilometros
	
	def void setMillas(double millas){
		this.millas = millas
		this.kilometros = this.millas * FACTOR_CONVERSION
	}
	
	def void setKilometros(double kilometros){
		this.kilometros = kilometros
		this.millas= this.kilometros / FACTOR_CONVERSION
	}	
}