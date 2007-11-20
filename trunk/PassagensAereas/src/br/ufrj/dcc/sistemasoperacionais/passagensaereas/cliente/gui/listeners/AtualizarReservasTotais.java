package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTable;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;

public class AtualizarReservasTotais extends AtualizarReservas {

	JLabel consultarReservasTotais;
	
	public AtualizarReservasTotais(JTable table, JLabel consultarReservas, JLabel consultarReservasTotais) {
		super(table, consultarReservas);
		this.consultarReservasTotais = consultarReservasTotais;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			int reservas = Cliente.getInstance().obtemTotalReservas();
			if (reservas < 0) {
				reservas = 0;
			}
			consultarReservasTotais.setText("Reservas totais: " + reservas);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		super.actionPerformed(e);
	}

}
