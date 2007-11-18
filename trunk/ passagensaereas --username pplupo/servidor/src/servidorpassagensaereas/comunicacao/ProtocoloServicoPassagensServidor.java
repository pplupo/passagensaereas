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

	private socketAdapter socket;
	private ServicoPassagensServidor servico;
	private final int c_ObtemTrechos = 1;
	private final int c_CompraTrecho = 4;
	private final int c_ReservaTrecho = 3;
	private final int c_ConsultaReserva = 5;
	private final int c_ConsultaCompras = 6;
	private final int c_ObtemVagasNoTrecho = 2;

	/** Creates a new instance of ProtocoloServicoPassagensServidor */
	public ProtocoloServicoPassagensServidor(ServicoPassagensServidor aServico, socketAdapter aSocket) {
		servico = aServico;
		socket = aSocket;
	}

	public void processaEventos() {
		boolean bConexaoAtiva = true;
		int iComando = 0;

		try {
			while (bConexaoAtiva) {
				iComando = socket.readInt();
				switch (iComando) {
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
					bConexaoAtiva = false;
					break;
				}
			}
		} catch (Exception ex) {
			bConexaoAtiva = false;
			System.err.println("Conexão cliente terminada.");
		}

	}

	public void obtemTrechos() throws IOException {
		String sResultado = servico.obtemTrechos();
		socket.SendString(sResultado);
	}

	public void obtemVagasNoTrecho() throws IOException {
		int iTrecho = socket.readInt();
		int iResultado = servico.obtemVagasNoTrecho(iTrecho);
		socket.sendInt(iResultado);
	}

	public void reservaTrecho() throws IOException {
		int iNumeroAssentos = socket.readInt();
		int iTrecho = socket.readInt();
		boolean bResultado = servico.reservaTrecho(iNumeroAssentos, iTrecho);
		socket.sendBoolean(bResultado);
	}

	public void compraTrecho() throws IOException {
		int iTrecho = socket.readInt();
		int iNumeroDeAssentos = socket.readInt();
		boolean bResultado = servico.compraTrecho(iTrecho, iNumeroDeAssentos);
		socket.sendBoolean(bResultado);
	}

	public void consultaReserva() throws IOException {
		int iTrecho = socket.readInt();
		int iResultado = servico.consultaReserva(iTrecho);
		socket.sendInt(iResultado);
	}

	public void consultaCompras() throws IOException {
		int iTrecho = socket.readInt();
		int iResultado = servico.consultaCompras(iTrecho);
		socket.sendInt(iResultado);
	}

}
