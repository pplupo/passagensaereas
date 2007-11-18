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
import servidorpassagensaereas.comunicacao.socketAdapter;

/**
 *
 * @author leone
 */
public class ConexaoCliente implements Runnable {
    
    private socketAdapter socket;
    private ServicoPassagensServidor servico;
    
    /** Creates a new instance of ConexaoCliente */
    public ConexaoCliente(socketAdapter aSocket, ServicoPassagensServidor aServico) {
        socket = aSocket;
        servico = aServico;
    }
    
    public void run() {
        ProtocoloServicoPassagensServidor protocoloNovaConexao = new ProtocoloServicoPassagensServidor(servico, socket);
        protocoloNovaConexao.processaEventos();
    }
}
