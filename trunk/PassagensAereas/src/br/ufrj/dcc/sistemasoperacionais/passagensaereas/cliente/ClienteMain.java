package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.TelaPrincipal;


public class ClienteMain {

	public static void main(String[] args) {
//		try {
//			Cliente cliente = Cliente.getInstance();
//			for (Trecho trecho : cliente.obtemTrechos()) {
//				System.out.println(trecho);
//			}
//			int t = cliente.consultaCompras(3);
//			System.out.println(t);
//			new TelaPrincipal();
//		} catch (IOException ex) {
//			System.err.println("Erro de conexão com o servidor...");
//			ex.printStackTrace();
//		} catch (Exception ex) {
//			System.err.println("Erro de conexão com o servidor...");
//			ex.printStackTrace();
//		}
		Cliente.getInstance();
		new TelaPrincipal();
	}

}
