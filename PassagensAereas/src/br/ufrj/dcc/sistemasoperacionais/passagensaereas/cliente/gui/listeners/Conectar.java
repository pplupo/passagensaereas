package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.swing.JTable;
import javax.swing.JTextField;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.TelaPrincipal;

public class Conectar extends Listener {
	
	private JTextField ip;
	private TelaPrincipal telaPrincipal;

	public Conectar(JTable table, JTextField ip, TelaPrincipal telaPrincipal) {
		super(table);
		this.ip = ip;
		this.telaPrincipal = telaPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		telaPrincipal.habilitarBotoes(false);
		try {
		Cliente.getInstance(ip.getText());
		super.actionPerformed(e);
		telaPrincipal.habilitarBotoes(true);
		} catch (ConnectException ex) {
			ex.printStackTrace();
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		}
	}
}