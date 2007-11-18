package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente;

import java.io.IOException;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle.Cliente;


public class ClienteMain {

	public static void main(String[] args) {
		try {
			Cliente cliente = Cliente.getInstance();
			for (String trecho : cliente.obtemTrechos()) {
				System.out.println(trecho);
			}
			int t = cliente.consultaCompras(3);
			System.out.println(t);
		} catch (IOException ex) {
			System.err.println("Erro de conexão com o servidor...");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.err.println("Erro de conexão com o servidor...");
			ex.printStackTrace();
		}
	}

}
