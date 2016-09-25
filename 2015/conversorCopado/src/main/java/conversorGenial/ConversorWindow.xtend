package conversorGenial

import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout
import java.awt.Color
import org.uqbar.arena.layout.ColumnLayout

class ConversorWindow extends MainWindow<Conversor> {
	
	new(){
		super(new Conversor)
	}
	
	override createContents(Panel mainPanel) {
		title = "Conversor de kilometros a millas"
		mainPanel.layout = new ColumnLayout(2)		
		val panelIzquierdo = new Panel(mainPanel)
		new Label(panelIzquierdo).text = "Ingrese millas"
		new TextBox(panelIzquierdo) => [
			bindValueToProperty("millas")
			background = Color.RED
		]
		
		val panelDerecho = new Panel(mainPanel)
		new Label(panelDerecho).text = "Ingrese kilometros"
		new TextBox(panelDerecho) => [
			bindValueToProperty("kilometros")
			background = Color.ORANGE
		]

	}

	def static main(String[] args){
		new ConversorWindow().startApplication
	}

}