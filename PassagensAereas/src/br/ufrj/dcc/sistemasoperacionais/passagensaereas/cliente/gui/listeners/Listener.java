package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Trecho;

public abstract class Listener implements ActionListener {
	
	protected JTable table;
	
	protected Listener(JTable table) {
		this.table = table;
	}

	public void actionPerformed(ActionEvent e) {
        try {
        	int linhaSelecionada = table.getSelectedRow();
			for (Trecho trecho : Cliente.getInstance().obtemTrechos()) {
//				table.setValueAt(trecho.getVagasDisponiveis(), trecho.getId()-1, 2);
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				tableModel.removeRow(0);
				tableModel.addRow(new Object[] {trecho.getId(), trecho.getNome(), trecho.getVagasDisponiveis()});
			}
			if (linhaSelecionada >= 0) {
				table.setRowSelectionInterval(linhaSelecionada, linhaSelecionada);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		//Atualizar reservas e compras totais
	}
	
}
