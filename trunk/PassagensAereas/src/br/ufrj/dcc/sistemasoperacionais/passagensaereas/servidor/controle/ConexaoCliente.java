package br.ufrj.dcc.sistemasoperacionais.passagensaereas.servidor.controle;

import java.io.IOException;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.comunicacao.SocketAdapter;

public class ConexaoCliente implements Runnable {
    
    private SocketAdapter socket;
    private ServicoPassagensServidor servico;
    
    public ConexaoCliente(SocketAdapter socket, ServicoPassagensServidor servico) {
        this.socket = socket;
        this.servico = servico;
    }
    
    public void run() {
		boolean conexaoAtiva = true;
		try {
			while (conexaoAtiva) {
				switch (socket.getComando()) {
					case OBTEM_TRECHOS:
						obtemTrechos();
						break;
					case COMPRA_TRECHO:
						compraTrecho();
						break;
					case RESERVA_TRECHO:
						reservaTrecho();
						break;
					case CONSULTA_RESERVA:
						consultaReserva();
						break;
					case CONSULTA_COMPRAS:
						consultaCompras();
						break;
					case OBTEM_VAGAS_NO_TRECHO:
						obtemVagasNoTrecho();
						break;
					case CONSULTA_TOTAL_RESERVAS:
						obtemTotalReservas();
						break;
					case CONSULTA_TOTAL_COMPRAS:
						obtemTotalCompras();
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
    
    public void obtemTotalReservas() throws IOException {
    	int resultado = servico.obtemTotalReservas();
    	socket.sendInt(resultado);
    }
    
    public void obtemTotalCompras() throws IOException {
    	int resultado = servico.obtemTotalCompras();
    	socket.sendInt(resultado);    	
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
		boolean resultado = servico.reservaTrecho(numeroAssentos, trecho, this);
		socket.sendBoolean(resultado);
	}

	public void compraTrecho() throws IOException {
		int numeroDeAssentos = socket.readInt();
		int trecho = socket.readInt();
		boolean resultado = servico.compraTrecho(trecho, numeroDeAssentos, this);
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
