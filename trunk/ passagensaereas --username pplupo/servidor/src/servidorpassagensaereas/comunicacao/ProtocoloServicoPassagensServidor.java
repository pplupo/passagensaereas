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

	private Socket2 socket;
	private ServicoPassagensServidor servico;
	private final int c_ObtemTrechos = 1;
	private final int c_CompraTrecho = 4;
	private final int c_ReservaTrecho = 3;
	private final int c_ConsultaReserva = 5;
	private final int c_ConsultaCompras = 6;
	private final int c_ObtemVagasNoTrecho = 2;

	/** Creates a new instance of ProtocoloServicoPassagensServidor */
	public ProtocoloServicoPassagensServidor(ServicoPassagensServidor aServico,
			Socket2 aSocket) {
		servico = aServico;
		socket = aSocket;
	}

	public void ProcessaEventos() {
		boolean bConexaoAtiva = true;
		int iComando = 0;

		try {
			while (bConexaoAtiva) {
				iComando = socket.ReadInt();
				switch (iComando) {
				case c_ObtemTrechos:
					ObtemTrechos();
					break;
				case c_CompraTrecho:
					CompraTrecho();
					break;
				case c_ReservaTrecho:
					ReservaTrecho();
					break;
				case c_ConsultaReserva:
					ConsultaReserva();
					break;
				case c_ConsultaCompras:
					ConsultaCompras();
					break;
				case c_ObtemVagasNoTrecho:
					ObtemVagasNoTrecho();
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

	public void ObtemTrechos() throws IOException {
		String sResultado = servico.ObtemTrechos();
		socket.SendString(sResultado);
	}

	public void ObtemVagasNoTrecho() throws IOException {
		int iTrecho = socket.ReadInt();
		int iResultado = servico.ObtemVagasNoTrecho(iTrecho);
		socket.SendInt(iResultado);
	}

	public void ReservaTrecho() throws IOException {
		int iNumeroAssentos = socket.ReadInt();
		int iTrecho = socket.ReadInt();
		boolean bResultado = servico.ReservaTrecho(iNumeroAssentos, iTrecho);
		socket.SendBoolean(bResultado);
	}

	public void CompraTrecho() throws IOException {
		int iTrecho = socket.ReadInt();
		int iNumeroDeAssentos = socket.ReadInt();
		boolean bResultado = servico.CompraTrecho(iTrecho, iNumeroDeAssentos);
		socket.SendBoolean(bResultado);
	}

	public void ConsultaReserva() throws IOException {
		int iTrecho = socket.ReadInt();
		int iResultado = servico.ConsultaReserva(iTrecho);
		socket.SendInt(iResultado);
	}

	public void ConsultaCompras() throws IOException {
		int iTrecho = socket.ReadInt();
		int iResultado = servico.ConsultaCompras(iTrecho);
		socket.SendInt(iResultado);
	}

}
