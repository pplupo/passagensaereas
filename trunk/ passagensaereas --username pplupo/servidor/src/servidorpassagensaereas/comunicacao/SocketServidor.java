/*
 * SocketServidor.java
 *
 * Created on 15 de Novembro de 2007, 06:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package servidorpassagensaereas.comunicacao;

import servidorpassagensaereas.funcionalidade.ConexaoCliente;
import servidorpassagensaereas.funcionalidade.ServicoPassagensServidor;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * 
 * @author leone
 */
public class SocketServidor implements Runnable {

	private ServerSocket serverSocket;
	private ServicoPassagensServidor servico;

	/** Creates a new instance of SocketServidor */
	public SocketServidor(int portaEscuta, ServicoPassagensServidor servico) {
		try {
			this.servico = servico;
			serverSocket = new ServerSocket(portaEscuta);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				SocketAdapter novoSocket = new SocketAdapter(serverSocket.accept());
				Thread thread = new Thread(new ConexaoCliente(novoSocket, servico));
				thread.start();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
