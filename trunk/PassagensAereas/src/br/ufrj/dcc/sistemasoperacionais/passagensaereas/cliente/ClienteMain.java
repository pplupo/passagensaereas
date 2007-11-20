package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.gui.TelaPrincipal;

import com.activetree.common.SmartJSwing;


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
		SmartJSwing.setLicenseKey("C7E7-A6D5-D25D-805A");
		new TelaPrincipal();
	}

}
