/*
 * ProtocoloServicoPassagensServidor.java
 *
 * Created on 15 de Novembro de 2007, 04:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package servidorpassagensaereas.comunicacao;

import java.io.IOException;

import servidorpassagensaereas.funcionalidade.ServicoPassagensServidor;

/**
 * 
 * @author leone
 */
public class ProtocoloServicoPassagensServidor {

	private SocketAdapter socket;
	private ServicoPassagensServidor servico;
	private final int c_ObtemTrechos = 1;
	private final int c_CompraTrecho = 4;
	private final int c_ReservaTrecho = 3;
	private final int c_ConsultaReserva = 5;
	private final int c_ConsultaCompras = 6;
	private final int c_ObtemVagasNoTrecho = 2;

	/** Creates a new instance of ProtocoloServicoPassagensServidor */
	public ProtocoloServicoPassagensServidor(ServicoPassagensServidor aServico, SocketAdapter aSocket) {
		servico = aServico;
		socket = aSocket;
	}

	public void processaEventos() {
		boolean conexaoAtiva = true;
		try {
			while (conexaoAtiva) {
				switch (socket.readInt()) {
				case c_ObtemTrechos:
					obtemTrechos();
					break;
				case c_CompraTrecho:
					compraTrecho();
					break;
				case c_ReservaTrecho:
					reservaTrecho();
					break;
				case c_ConsultaReserva:
					consultaReserva();
					break;
				case c_ConsultaCompras:
					consultaCompras();
					break;
				case c_ObtemVagasNoTrecho:
					obtemVagasNoTrecho();
					break;
				default:
					conexaoAtiva = false;
					break;
				}
			}
		} catch (Exception ex) {
			conexaoAtiva = false;
			System.err.println("Conexão cliente terminada.");
		}

	}

	public void obtemTrechos() throws IOException {
		String resultado = servico.obtemTrechos();
		socket.sendString(resultado);
	}

	public void obtemVagasNoTrecho() throws IOException {
		int trecho = socket.readInt();
		int resultado = servico.obtemVagasNoTrecho(trecho);
		socket.sendInt(resultado);
	}

	public void reservaTrecho() throws IOException {
		int numeroAssentos = socket.readInt();
		int trecho = socket.readInt();
		boolean resultado = servico.reservaTrecho(numeroAssentos, trecho);
		socket.sendBoolean(resultado);
	}

	public void compraTrecho() throws IOException {
		int trecho = socket.readInt();
		int numeroDeAssentos = socket.readInt();
		boolean resultado = servico.compraTrecho(trecho, numeroDeAssentos);
		socket.sendBoolean(resultado);
	}

	public void consultaReserva() throws IOException {
		int trecho = socket.readInt();
		int resultado = servico.consultaReserva(trecho);
		socket.sendInt(resultado);
	}

	public void consultaCompras() throws IOException {
		int trecho = socket.readInt();
		int resultado = servico.consultaCompras(trecho);
		socket.sendInt(resultado);
	}

}
