package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;

public class EfetuarReservas extends Listener {

	JFormattedTextField quantidadeReservas;
	JLabel consultarReservas;
	
	public EfetuarReservas(JTable table, JFormattedTextField quantidadeReservas, JLabel consultarReservas) {
		super(table);
		this.quantidadeReservas = quantidadeReservas;
		this.consultarReservas = consultarReservas;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			boolean resultado;
			resultado = Cliente.getInstance().reservaTrecho(Integer.parseInt(quantidadeReservas.getText()), (Integer)table.getModel().getValueAt(table.getSelectedRow(), 0));
			if (resultado) { 
				quantidadeReservas.setText("0");
				consultarReservas.setText("reserva efetuada com sucesso.");
			}
			else {
				consultarReservas.setText("não foi possível efetuar a reserva, verifique a disponibilidade de assentos.");
			}
		} catch (NumberFormatException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException ex) {
			consultarReservas.setText("primeiro selecione um trecho.");
		}
		super.actionPerformed(e);
	}

}
