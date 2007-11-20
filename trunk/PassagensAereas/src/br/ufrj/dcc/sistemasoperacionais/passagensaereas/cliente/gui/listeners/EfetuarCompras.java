package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;

public class EfetuarCompras extends Listener {
	
	private JFormattedTextField quantidadeCompras;
	private JLabel consultarCompras;

	public EfetuarCompras (JTable table, JFormattedTextField quantidadeCompras, JLabel consultarCompras) {
		super(table);
		this.quantidadeCompras = quantidadeCompras;
		this.consultarCompras = consultarCompras;		
	}

	public void actionPerformed(ActionEvent e) {
		try {
			boolean resultado = Cliente.getInstance().compraTrecho(Integer.parseInt(quantidadeCompras.getText()), (Integer)table.getModel().getValueAt(table.getSelectedRow(), 0));
			if (resultado) { 
				quantidadeCompras.setText("0");
				consultarCompras.setText("compra efetuada com sucesso.");
			}
			else {
				consultarCompras.setText("não foi possível efetuar a compra, verifique se já foi feita a reserva.");
			}
			
		} catch (NumberFormatException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException ex) {
			consultarCompras.setText("primeiro selecione um trecho.");
		}
		super.actionPerformed(e);
	}

}
