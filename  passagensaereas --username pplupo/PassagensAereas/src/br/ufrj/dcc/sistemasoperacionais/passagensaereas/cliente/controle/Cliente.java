package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle;

import java.io.IOException;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.comunicacao.Protocolo;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.comunicacao.SocketAdapter;

public class Cliente {

	private static SocketAdapter socket = new SocketAdapter();
	private static Cliente instance;
	
	public static Cliente getInstance() {
		if (instance == null) {
			instance = new Cliente();
		}
		return instance;
	}

	private Cliente() {
		socket.connectTo("localhost", 5000);
	}

	public String[] obtemTrechos() throws IOException {
		socket.sendComando(Protocolo.OBTEM_TRECHOS);
		return socket.readString().split(";");
	}

	public int obtemVagasNoTrecho(int trecho) throws IOException {
		socket.sendComando(Protocolo.OBTEM_VAGAS_NO_TRECHO);
		socket.sendInt(trecho);
		return socket.readInt();
	}

	public boolean reservaTrecho(int numeroAssentos, int trecho) throws IOException {
		socket.sendComando(Protocolo.RESERVA_TRECHO);
		socket.sendInt(numeroAssentos);
		socket.sendInt(trecho);
		return socket.readBoolean();
	}

	public boolean compraTrecho(int numeroAssentos, int trecho) throws IOException {
		socket.sendComando(Protocolo.COMPRA_TRECHO);
		socket.sendInt(numeroAssentos);
		socket.sendInt(trecho);
		return socket.readBoolean();
	}

	public int consultaReserva(int trecho) throws IOException {
		socket.sendComando(Protocolo.CONSULTA_RESERVA);
		socket.sendInt(trecho);
		return socket.readInt();
	}

	public int consultaCompras(int trecho) throws IOException {
		socket.sendComando(Protocolo.CONSULTA_COMPRAS);
		socket.sendInt(trecho);
		return socket.readInt();
	}

}
