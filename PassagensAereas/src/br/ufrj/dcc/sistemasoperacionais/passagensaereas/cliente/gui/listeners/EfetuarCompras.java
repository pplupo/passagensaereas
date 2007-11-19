package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;

public class EfetuarCompras extends AtualizarCompras {
	
	private JFormattedTextField quantidadeCompras;

	protected EfetuarCompras(JTable table) {
		super(table);
	}
	
	public EfetuarCompras (JTable table, JFormattedTextField quantidadeCompras, JLabel consultarCompras) {
		super(table, consultarCompras);
		this.quantidadeCompras = quantidadeCompras;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			Cliente.getInstance().compraTrecho(Integer.parseInt(quantidadeCompras.getText()), (Integer)table.getModel().getValueAt(table.getSelectedRow(), 0));
			quantidadeCompras.setText("0");
		} catch (NumberFormatException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException ex) {
			//nenhuma linha selecionada (linha = -1)
		}
		super.actionPerformed(e);
	}

}
