package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTable;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;

public class AtualizarReservas extends Listener {

	JLabel consultarReservas;
	
	protected AtualizarReservas(JTable table) {
		super(table);
	}
	
	public AtualizarReservas(JTable table, JLabel consultarReservas) {
		super(table);
		this.consultarReservas = consultarReservas;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			int reservas = Cliente.getInstance().consultaReserva((Integer)table.getModel().getValueAt(table.getSelectedRow(), 0));
			if (reservas < 0) {
				reservas = 0;
			}
			consultarReservas.setText("Reservas: " + reservas);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException ex) {
			//nenhuma linha selecionada (linha = -1)
		}
		super.actionPerformed(e);
	}

}
