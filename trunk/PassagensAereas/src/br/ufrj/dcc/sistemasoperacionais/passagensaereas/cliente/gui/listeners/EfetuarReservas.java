package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;

public class EfetuarReservas extends AtualizarReservas {

	JFormattedTextField quantidadeReservas;
	JLabel consultarReservas;
	
	protected EfetuarReservas(JTable table) {
		super(table);
	}
	
	public EfetuarReservas(JTable table, JFormattedTextField quantidadeReservas, JLabel consultarReservas) {
		super(table, consultarReservas);
		this.quantidadeReservas = quantidadeReservas;
		this.consultarReservas = consultarReservas;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			Cliente.getInstance().reservaTrecho(Integer.parseInt(quantidadeReservas.getText()), (Integer)table.getModel().getValueAt(table.getSelectedRow(), 0));
			quantidadeReservas.setText("0");
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
