package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle;

import java.io.IOException;
import java.net.ServerSocket;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.comunicacao.SocketAdapter;

public class Servidor extends Thread {

	private static Servidor instance;
    private static final ServicoPassagensServidor servico = new ServicoPassagensServidor();
	private static ServerSocket serverSocket;
	
	public static Servidor getInstance() {
		if (instance == null) {
			instance = new Servidor();
		}
		return instance;
	}
	
	private Servidor() {
		try {
			serverSocket = new ServerSocket(5000);
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
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
