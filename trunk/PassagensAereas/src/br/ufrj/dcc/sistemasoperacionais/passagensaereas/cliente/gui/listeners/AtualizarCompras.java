package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTable;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;

public class AtualizarCompras extends Listener {

	JLabel consultarCompras;
	
	protected AtualizarCompras(JTable table) {
		super(table);
		// TODO Auto-generated constructor stub
	}

	public AtualizarCompras(JTable table, JLabel consultarCompras) {
		super(table);
		this.consultarCompras = consultarCompras;
	}

	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		try {
			int compras = Cliente.getInstance().consultaCompras((Integer)table.getModel().getValueAt(table.getSelectedRow(), 0));
			if (compras < 0) {
				compras = 0;
			}
			consultarCompras.setText("Compras: " + compras);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException ex) {
			//nenhuma linha selecionada (linha = -1)
		}
	}


}
