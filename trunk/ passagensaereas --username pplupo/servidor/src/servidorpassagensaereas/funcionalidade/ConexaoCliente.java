/*
 * ConexaoCliente.java
 *
 * Created on 15 de Novembro de 2007, 07:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package servidorpassagensaereas.funcionalidade;

import servidorpassagensaereas.comunicacao.ProtocoloServicoPassagensServidor;
import servidorpassagensaereas.comunicacao.Socket2;

/**
 *
 * @author leone
 */
public class ConexaoCliente implements Runnable {
    
    private Socket2 socket;
    private ServicoPassagensServidor servico;
    
    /** Creates a new instance of ConexaoCliente */
    public ConexaoCliente(Socket2 aSocket, ServicoPassagensServidor aServico) {
        socket = aSocket;
        servico = aServico;
    }
    
    public void run() {
        ProtocoloServicoPassagensServidor protocoloNovaConexao = new ProtocoloServicoPassagensServidor(servico, socket);
        protocoloNovaConexao.ProcessaEventos();
    }
}
