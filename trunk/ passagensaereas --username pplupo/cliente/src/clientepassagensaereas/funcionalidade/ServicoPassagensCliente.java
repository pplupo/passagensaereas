/*
 * ServicoPassagensServidor.java
 *
 * Created on 15 de Novembro de 2007, 05:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clientepassagensaereas.funcionalidade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import clientepassagensaereas.comunicacao.ProtocoloServicoPassagensCliente;
import clientepassagensaereas.comunicacao.SocketAdapter;

/**
 * 
 * @author leone
 */
public class ServicoPassagensCliente {

	ProtocoloServicoPassagensCliente servicoRemoto;

	/** Creates a new instance of ServicoPassagensCliente */
	public ServicoPassagensCliente(SocketAdapter aSocket) {
		servicoRemoto = new ProtocoloServicoPassagensCliente(aSocket);
	}

	public Collection obtemTrechos() throws IOException {
		String[] trechosArray = servicoRemoto.obtemTrechos().split(";");
		Collection trechos = new ArrayList(trechosArray.length);
		for (int i = 0; i < trechosArray.length; i++) {
			trechos.add(trechosArray[i]);
		}
		return trechos;
	}

	public int obtemVagasNoTrecho(int trecho) throws IOException {
		return servicoRemoto.obtemVagasNoTrecho(trecho);
	}

	public boolean reservaTrecho(int numeroDeAssentos, int trecho) throws IOException {
		return servicoRemoto.reservaTrecho(numeroDeAssentos, trecho);
	}

	public boolean compraTrecho(int trecho, int numeroDeAssentos) throws IOException {
		return servicoRemoto.compraTrecho(trecho, numeroDeAssentos);
	}

	public int consultaReserva(int trecho) throws IOException {
		return servicoRemoto.consultaReserva(trecho);
	}

	public int consultaCompras(int trecho) throws IOException {
		return servicoRemoto.consultaCompras(trecho);
	}
}
