package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTable;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;

public class AtualizarComprasTotais extends Listener {

	JLabel consultarTotalCompras;
	
	protected AtualizarComprasTotais(JTable table) {
		super(table);
	}

	public AtualizarComprasTotais(JTable table, JLabel consultarComprasTotais) {
		super(table);
		this.consultarTotalCompras = consultarComprasTotais;
	}

	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
//		try {
//			int compras = Cliente.getInstance().consultarComprasTotais();
//			if (compras < 0) {
//				compras = 0;
//			}
//			consultarComprasTotais.setText("Compras: " + compras);
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
	}


}
