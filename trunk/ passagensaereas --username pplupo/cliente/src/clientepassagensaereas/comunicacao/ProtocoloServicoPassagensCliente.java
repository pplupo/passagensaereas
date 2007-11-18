/*
 * ProtocoloServicoPassagensServidor.java
 *
 * Created on 15 de Novembro de 2007, 04:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clientepassagensaereas.comunicacao;

import java.io.IOException;

/**
 * 
 * @author leone
 */
public class ProtocoloServicoPassagensCliente {

	private SocketAdapter socket;
	private final int c_ObtemTrechos = 1;
	private final int c_CompraTrecho = 4;
	private final int c_ReservaTrecho = 3;
	private final int c_ConsultaReserva = 5;
	private final int c_ConsultaCompras = 6;
	private final int c_ObtemVagasNoTrecho = 2;

	/** Creates a new instance of ProtocoloServicoPassagensCliente */
	public ProtocoloServicoPassagensCliente(SocketAdapter aSocket) {
		socket = aSocket;
	}

	public String obtemTrechos() throws IOException {
		socket.sendInt(c_ObtemTrechos);
		return socket.readString();
	}

	public int obtemVagasNoTrecho(int trecho) throws IOException {
		socket.sendInt(c_ObtemVagasNoTrecho);
		socket.sendInt(trecho);
		return socket.readInt();
	}

	public boolean reservaTrecho(int numeroAssentos, int trecho)
			throws IOException {
		socket.sendInt(c_ReservaTrecho);
		socket.sendInt(numeroAssentos);
		socket.sendInt(trecho);
		return socket.readBoolean();
	}

	public boolean compraTrecho(int numeroAssentos, int trecho)
			throws IOException {
		socket.sendInt(c_CompraTrecho);
		socket.sendInt(numeroAssentos);
		socket.sendInt(trecho);
		return socket.readBoolean();
	}

	public int consultaReserva(int trecho) throws IOException {
		socket.sendInt(c_ConsultaReserva);
		socket.sendInt(trecho);
		return socket.readInt();
	}

	public int consultaCompras(int trecho) throws IOException {
		socket.sendInt(c_ConsultaCompras);
		socket.sendInt(trecho);
		return socket.readInt();
	}

}
