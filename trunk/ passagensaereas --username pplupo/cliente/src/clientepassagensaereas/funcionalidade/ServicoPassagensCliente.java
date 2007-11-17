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
import java.util.List;

import clientepassagensaereas.comunicacao.ProtocoloServicoPassagensCliente;
import clientepassagensaereas.comunicacao.Socket2;
/**
 *
 * @author leone
 */
public class ServicoPassagensCliente {

    ProtocoloServicoPassagensCliente servicoRemoto;
    
    /** Creates a new instance of ServicoPassagensCliente */
    public ServicoPassagensCliente(Socket2 aSocket) {
      servicoRemoto = new ProtocoloServicoPassagensCliente(aSocket);      
    }
    
    public List ObtemTrechos() throws IOException {
      String sTrecho, sTrechos = servicoRemoto.ObtemTrechos();
      ArrayList lTrechos = new ArrayList();
      int i = 0, f;
      while ((f = sTrechos.indexOf(';', i)) > -1) {
          sTrecho = sTrechos.substring(i, f);
          lTrechos.add(sTrecho);
          i = f + 1;
      }
      return lTrechos;
    }
    
    public int ObtemVagasNoTrecho(int aTrecho) throws IOException {
      return servicoRemoto.ObtemVagasNoTrecho(aTrecho);
    }
    
    public boolean ReservaTrecho(int aNumeroDeAssentos, int aTrecho) throws IOException {
      return servicoRemoto.ReservaTrecho(aNumeroDeAssentos, aTrecho);
    }   
    
    public boolean CompraTrecho(int aTrecho, int aNumeroDeAssentos) throws IOException {
      return servicoRemoto.CompraTrecho(aTrecho, aNumeroDeAssentos);
    }
    
    public int ConsultaReserva(int aTrecho) throws IOException {
      return servicoRemoto.ConsultaReserva(aTrecho);
    }
    
    public int ConsultaCompras(int aTrecho) throws IOException {
      return servicoRemoto.ConsultaCompras(aTrecho);
    }
}
