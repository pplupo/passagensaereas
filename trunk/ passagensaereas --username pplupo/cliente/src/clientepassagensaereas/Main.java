/*
 * Main.java
 *
 * Created on 16 de Novembro de 2007, 11:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clientepassagensaereas;

import java.util.Iterator;

import clientepassagensaereas.comunicacao.SocketAdapter;
import clientepassagensaereas.funcionalidade.ServicoPassagensCliente;

/**
 * 
 * @author leone
 */
public class Main {

	/** Creates a new instance of Main */
	public Main() {
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		try {
			SocketAdapter socket = new SocketAdapter();
			socket.connectTo("localhost", 5000);
			ServicoPassagensCliente servico = new ServicoPassagensCliente(socket);
			for (Iterator it = servico.obtemTrechos().iterator(); it.hasNext();) {
				System.out.println(it.next());
			}
			int t = servico.consultaCompras(3);
			System.out.println(t);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Erro de conexão com o servidor...");
		}
	}

}
