package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTable;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;

public class AtualizarComprasTotais extends AtualizarCompras {

	JLabel consultarTotalCompras;
	
	public AtualizarComprasTotais(JTable table, JLabel consultarCompras, JLabel consultarComprasTotais) {
		super(table, consultarCompras);
		this.consultarTotalCompras = consultarComprasTotais;
	}

	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		try {
			int compras = Cliente.getInstance().obtemTotalCompras();
			if (compras < 0) {
				compras = 0;
			}
			this.consultarTotalCompras.setText("Compras totais: " + compras);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


}
