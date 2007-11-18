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
		// String sTrecho, sTrechos = servicoRemoto.obtemTrechos();
		// int i = 0, f;
		// while ((f = sTrechos.indexOf(';', i)) > -1) {
		// sTrecho = sTrechos.substring(i, f);
		// lTrechos.add(sTrecho);
		// i = f + 1;
		// }
		String[] trechosArray = servicoRemoto.obtemTrechos().split(";");
		Collection trechos = new ArrayList(trechosArray.length);
		for (int i = 0; i < trechosArray.length; i++) {
			trechos.add(trechosArray[i]);
		}
		return trechos;
	}

	public int obtemVagasNoTrecho(int aTrecho) throws IOException {
		return servicoRemoto.obtemVagasNoTrecho(aTrecho);
	}

	public boolean reservaTrecho(int aNumeroDeAssentos, int aTrecho) throws IOException {
		return servicoRemoto.reservaTrecho(aNumeroDeAssentos, aTrecho);
	}

	public boolean compraTrecho(int aTrecho, int aNumeroDeAssentos) throws IOException {
		return servicoRemoto.compraTrecho(aTrecho, aNumeroDeAssentos);
	}

	public int consultaReserva(int aTrecho) throws IOException {
		return servicoRemoto.consultaReserva(aTrecho);
	}

	public int consultaCompras(int aTrecho) throws IOException {
		return servicoRemoto.consultaCompras(aTrecho);
	}
}
