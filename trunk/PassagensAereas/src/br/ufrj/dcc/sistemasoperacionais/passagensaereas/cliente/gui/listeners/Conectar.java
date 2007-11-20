package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.listeners;

import java.awt.event.ActionEvent;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.swing.JTable;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.TelaPrincipal;

import com.activetree.view.AtIPAddressField;

public class Conectar extends Listener {
	
	private AtIPAddressField ip;
	private TelaPrincipal telaPrincipal;

	public Conectar(JTable table, AtIPAddressField ip, TelaPrincipal telaPrincipal) {
		super(table);
		this.ip = ip;
		this.telaPrincipal = telaPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		try {
		Cliente.getInstance(ip.getModel().getAtString());
		super.actionPerformed(e);
		telaPrincipal.habilitarBotoes();
		} catch (ConnectException ex) {
			ex.printStackTrace();
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		}
	}
}