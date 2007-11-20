package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTable;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;

public class ConsultaVagas extends Listener {
	
	private JLabel consultaVagas;

	public ConsultaVagas(JTable table, JLabel consultaVagas) {
		super(table);
		this.consultaVagas = consultaVagas;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			int idTrecho = (Integer)table.getModel().getValueAt(table.getSelectedRow(), 0);
			int numVagas = Cliente.getInstance().obtemVagasNoTrecho(idTrecho);
			consultaVagas.setText("existem " + numVagas + " assentos disponíveis.");
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException ex) {
			consultaVagas.setText("primeiro selecione um trecho.");
		}
		super.actionPerformed(e);
	}
	
	

}
