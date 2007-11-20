package br.ufrj.dcc.sistemasoperacionais.passagensaereas.cliente.controle;

import java.io.IOException;
import java.util.Collection;
import java.util.TreeSet;

import br.ufrj.dcc.sistemasoperacionais.passagensaereas.comunicacao.Protocolo;
import br.ufrj.dcc.sistemasoperacionais.passagensaereas.comunicacao.SocketAdapter;

public class Cliente {

	private static SocketAdapter socket = new SocketAdapter();
	private static Cliente instance;
	private static String lastIP = "";
	
	public static Cliente getInstance(String ip) {
		if (ip == null || lastIP.equals(ip)) {
			return null;
		}
		if (!lastIP.equals(ip)) {
			instance = new Cliente(ip);
		}
		return instance;
	}
	
	public static Cliente getInstance() {
		return instance;
	}

	private Cliente(String ip) {
		socket.connectTo(ip, 5000);
	}

	public Collection<Trecho> obtemTrechos() throws IOException {
		Collection<Trecho> trechos = new TreeSet<Trecho>();
		socket.sendComando(Protocolo.OBTEM_TRECHOS);
		String[] dadosTrechos = socket.readString().split(";");
		for (String dadosTrecho : dadosTrechos) {
			String[] trecho = dadosTrecho.split("@");
			trechos.add(new Trecho(Integer.parseInt(trecho[0]),
									trecho[1],
									Integer.parseInt(trecho[2])));
		}
		return trechos;
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
	
    public int obtemTotalCompras() throws IOException {
    	socket.sendComando(Protocolo.CONSULTA_TOTAL_COMPRAS);
    	return socket.readInt();
    }
    
    public int obtemTotalReservas() throws IOException {
    	socket.sendComando(Protocolo.CONSULTA_TOTAL_RESERVAS);
    	return socket.readInt();
    }
	

}
